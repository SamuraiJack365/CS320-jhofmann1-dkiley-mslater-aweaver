package xyz.jhofmann1.cs320.database.studentsdb.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.jhofmann1.cs320.database.studentsdb.model.Student;
import xyz.jhofmann1.cs320.database.studentsdb.model.Major;
import xyz.jhofmann1.cs320.database.studentsdb.model.Minor;

public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;
	
	// wrapper SQL transaction function that calls actual transaction function (which has retries)
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	// SQL transaction function which retries the transaction MAX_ATTEMPTS times before failing
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
				
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}
	
	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:students.db;create=true");		
		
		// Set autocommit() to false to allow the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	// creates tables
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;	
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				//PreparedStatement stmt4 = null;
				//PreparedStatement stmt5 = null;
			
				try {
					stmt1 = conn.prepareStatement(
						"create table students (" +
						"	id integer primary key " +
						"		generated always as identity (start with 1, increment by 1), " +
						"	ycp_id integer," +
						"	firstname varchar(40)," +
						"	lastname varchar(40)," +
						"   major integer," +
						"   picture varchar(40),"+
						"   sport integer," +
						"   club integer," +
						"   gpa double," +
						"   displaygpa boolean," + 
						"   isreviewed boolean" +
						")"
					);
					stmt1.executeUpdate();
					
					System.out.println("Students table created");
					
					stmt2 = conn.prepareStatement(
						"create table majors (" +
						" 	major_id integer primary key " +
						"		generated always as identity (start with 1, increment by 1), " +
						"	major varchar(50)" +
						")"
					);
					
					stmt2.executeUpdate();
					
					System.out.println("Majors table created");
					
					stmt3 = conn.prepareStatement(
							"create table minors (" +
							" 	minor_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	minor varchar(50)" +
							")"
						);
					
					stmt3.executeUpdate();
					
					System.out.println("Minors table created");
					
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
				}
			}
		});
	}
	
	// loads data retrieved from CSV files into DB tables in batch mode
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<Student> studentList;
				List<Major> majorList;
				List<Minor>	minorList;
				
				try {
					studentList     = InitialData.getStudents();
					majorList		= InitialData.getMajors();
					minorList		= InitialData.getMinors();
					
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertStudent     = null;
				PreparedStatement insertMajor		= null;
				PreparedStatement insertMinor 		= null;
				

				try {
					// must completely populate Authors table before populating BookAuthors table because of primary keys
					insertStudent = conn.prepareStatement("insert into students (ycp_id, firstname, lastname, major, picture, sport, club, gpa, displaygpa, isreviewed) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
					for (Student student : studentList) {
//							insertAuthor.setInt(1, student.getStudentId());	// auto-generated primary key, don't insert this
						insertStudent.setInt(1,  student.getYcpId());
						insertStudent.setString(2, student.getFirstName());
						insertStudent.setString(3, student.getLastName());
						insertStudent.setInt(4, student.getMajor());
						insertStudent.setString(5, student.getPicture());
						insertStudent.setInt(6, student.getSport());
						insertStudent.setInt(7, student.getClub());
						insertStudent.setDouble(8, student.getGPA());
						insertStudent.setBoolean(9, student.getDisplayGPA());
						insertStudent.setBoolean(10, student.getIsReviewed());
						insertStudent.addBatch();
					}
					insertStudent.executeBatch();
					
					System.out.println("Students table populated");
					
					// must completely populate Books table before populating BookAuthors table because of primary keys
					insertMajor = conn.prepareStatement("insert into majors (major) values (?)");
					for (Major major : majorList) {
						insertMajor.setString(1, major.getMajor());
						insertMajor.addBatch();
					}
					insertMajor.executeBatch();
					
					System.out.println("Majors table populated");					
//					
					// must completely populate Books table before populating BookAuthors table because of primary keys
					insertMinor = conn.prepareStatement("insert into minors (minor) values (?)");
					for (Minor minor : minorList) {
						insertMinor.setString(1, minor.getMinor());
						insertMinor.addBatch();
					}
					insertMinor.executeBatch();
					
					System.out.println("Minors table populated");	
//					// must wait until all Books and all Authors are inserted into tables before creating BookAuthor table
//					// since this table consists entirely of foreign keys, with constraints applied
//					insertBookAuthor = conn.prepareStatement("insert into bookAuthors (book_id, author_id) values (?, ?)");
//					for (BookAuthor bookAuthor : bookAuthorList) {
//						insertBookAuthor.setInt(1, bookAuthor.getBookId());
//						insertBookAuthor.setInt(2, bookAuthor.getAuthorId());
//						insertBookAuthor.addBatch();
//					}
//					insertBookAuthor.executeBatch();	
//					
//					System.out.println("BookAuthors table populated");					
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertStudent);	
					DBUtil.closeQuietly(insertMajor);
					DBUtil.closeQuietly(insertMinor);
				}
			}
		});
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Student DB successfully initialized!");
	}
			

}
