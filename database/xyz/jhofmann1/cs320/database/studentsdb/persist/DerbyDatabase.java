package xyz.jhofmann1.cs320.database.studentsdb.persist;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.jhofmann1.cs320.database.studentsdb.model.Student;
import xyz.jhofmann1.cs320.database.studentsdb.model.StudentAdvisor;
import xyz.jhofmann1.cs320.model.main.Credentials;
import xyz.jhofmann1.cs320.database.studentsdb.model.Advisor;
import xyz.jhofmann1.cs320.database.studentsdb.model.Club;
import xyz.jhofmann1.cs320.database.studentsdb.model.Major;
import xyz.jhofmann1.cs320.database.studentsdb.model.Minor;
import xyz.jhofmann1.cs320.database.studentsdb.model.Sport;

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
				PreparedStatement stmt4 = null;
				PreparedStatement stmt5 = null;
				PreparedStatement stmt6 = null;
				PreparedStatement stmt7 = null;
				PreparedStatement stmt8 = null;
			
				try {
					
					stmt1 = conn.prepareStatement(
						"create table majors (" +
						" 	major_id integer primary key " +
						"		generated always as identity (start with 1, increment by 1), " +
						"	major varchar(50)" +
						")"
					);
					
					stmt1.executeUpdate();
					
					System.out.println("Majors table created");
					
					stmt2 = conn.prepareStatement(
							"create table minors (" +
							" 	minor_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	minor varchar(50)" +
							")"
						);
					
					stmt2.executeUpdate();
					
					System.out.println("Minors table created");
					
					stmt3 = conn.prepareStatement(
							"create table sports (" +
							" 	sport_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	sport varchar(40)" +
							")"
						);
					
					stmt3.executeUpdate();
					
					System.out.println("Sports table created");
					
					stmt4 = conn.prepareStatement(
							"create table clubs (" +
							" 	club_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	club varchar(40)" +
							")"
						);
					
					stmt4.executeUpdate();
					
					System.out.println("Clubs table created");
					
					stmt5 = conn.prepareStatement(
							"create table users (" +
							"	username varchar(40) primary key, " +
							"	password varchar(255)" +
							")"
						);
					
					stmt5.executeUpdate();
					
					System.out.println("Users table created");
					
					stmt6 = conn.prepareStatement(
							"create table advisors (" +
							" 	advisor_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	firstname varchar(40)," +
							"   lastname varchar(40)," +
							"	username varchar(40) references users(username)" +
 							")"
						);
					
					stmt6.executeUpdate();
					
					System.out.println("Advisors table created");
					
					stmt7 = conn.prepareStatement(
							"create table students (" +
							"	student_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	ycp_id integer," +
							"	firstname varchar(40)," +
							"	lastname varchar(40)," +
							"   major_id integer references majors(major_id)," +
							"   picture varchar(40),"+
							"   sport_id integer references sports(sport_id)," +
							"   club_id integer references clubs(club_id)," +
							"   gpa double," +
							"   displaygpa boolean," + 
							"   isreviewed boolean," +
							"	username varchar(40) references users(username)" +
//							"   FOREIGN KEY (MAJOR) REFERENCES MAJORS (MAJOR_ID)" +
							")"
						);
					stmt7.executeUpdate();
						
					System.out.println("Students table created");
					
					stmt8 = conn.prepareStatement(
							"create table studentAdvisors (" +
							"	student_id integer references students(student_id), " +
							"	advisor_id integer references advisors(advisor_id)" +
							")"
						);
					
					stmt8.executeUpdate();
					
					System.out.println("StudentAdvisors table created");	
					
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
					DBUtil.closeQuietly(stmt4);
					DBUtil.closeQuietly(stmt5);
					DBUtil.closeQuietly(stmt6);
					DBUtil.closeQuietly(stmt7);
					DBUtil.closeQuietly(stmt8);
				}
			}
		});
	}
	
	// loads data retrieved from CSV files into DB tables in batch mode
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<Major> majorList;
				List<Minor>	minorList;
				List<Sport>	sportList;
				List<Club>	clubList;
				List<Credentials> userList;
				List<Advisor> advisorList;
				List<Student> studentList;
				List<StudentAdvisor> studentAdvisorList;
				
				try {
					majorList			= InitialData.getMajors();
					minorList			= InitialData.getMinors();
					sportList 			= InitialData.getSports();
					clubList			= InitialData.getClubs();
					userList			= InitialData.getUsers();
					advisorList 		= InitialData.getAdvisors();
					studentList     	= InitialData.getStudents();
					studentAdvisorList 	= InitialData.getStudentAdvisors();
					
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertMajor			= null;
				PreparedStatement insertMinor 			= null;
				PreparedStatement insertSport			= null;
				PreparedStatement insertClub			= null;
				PreparedStatement insertUser			= null;
				PreparedStatement insertAdvisor			= null;
				PreparedStatement insertStudent     	= null;
				PreparedStatement insertStudentAdvisor 	= null;
				

				try {
					// must completely populate Authors table before populating BookAuthors table because of primary keys
					
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
					
					insertSport = conn.prepareStatement("insert into sports (sport) values (?)");
					for (Sport sport: sportList) {
						insertSport.setString(1, sport.getSport());
						insertSport.addBatch();
					}
					insertSport.executeBatch();
					
					System.out.println("Sports table populated");
					
					insertClub = conn.prepareStatement("insert into clubs (club) values (?)");
					for (Club club : clubList) {
						insertClub.setString(1, club.getClub());
						insertClub.addBatch();
					}
					insertClub.executeBatch();
					
					System.out.println("Clubs table populated");
					
					insertUser = conn.prepareStatement("insert into users (username, password) values (?,?)");
					for (Credentials cred : userList) {
						insertUser.setString(1, cred.getUsername());
						insertUser.setString(2, cred.getHashedPassword());
						insertUser.addBatch();
					}
					insertUser.executeBatch();
					
					System.out.println("Users table populated");
					
					insertAdvisor = conn.prepareStatement("insert into advisors (firstname, lastname, username) values (?,?,?)");
					for (Advisor advisor : advisorList) {
						insertAdvisor.setString(1, advisor.getFirstName());
						insertAdvisor.setString(2, advisor.getLastName());
						insertAdvisor.setString(3, advisor.getUserName());
						//insertAdvisor.setString(3,  advisor.getEmail());
						insertAdvisor.addBatch();
					}
					insertAdvisor.executeBatch();
					
					System.out.println("Advisors table populated");
					
					insertStudent = conn.prepareStatement("insert into students (ycp_id, firstname, lastname, major_id, picture, sport_id, club_id, gpa, displaygpa, isreviewed, username) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
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
						insertStudent.setString(11, student.getUserName());
						insertStudent.addBatch();
					}
					insertStudent.executeBatch();
					
					System.out.println("Students table populated");
				
//					// must wait until all Books and all Authors are inserted into tables before creating BookAuthor table
//					// since this table consists entirely of foreign keys, with constraints applied
//					insertBookAuthor = conn.prepareStatement("insert into bookAuthors (book_id, author_id) values (?, ?)");
//					for (BookAuthor bookAuthor : bookAuthorList) {
//						insertBookAuthor.setInt(1, bookAuthor.getBookId());
//						insertBookAuthor.setInt(2, bookAuthor.getAuthorId());
//					}
//					insertBookAuthor.executeBatch();	
//					
//					System.out.println("BookAuthors table populated");		
					
					insertStudentAdvisor = conn.prepareStatement("insert into studentAdvisors (student_id, advisor_id) values (?,?)");
					for (StudentAdvisor studentAdvisor : studentAdvisorList) {
						insertStudentAdvisor.setInt(1, studentAdvisor.getStudentId());
						insertStudentAdvisor.setInt(2, studentAdvisor.getAdvisorId());
						insertStudentAdvisor.addBatch();
					}
					insertStudentAdvisor.executeBatch();
					
					System.out.println("studentAdvisors table populated");
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertMajor);
					DBUtil.closeQuietly(insertMinor);
					DBUtil.closeQuietly(insertSport);
					DBUtil.closeQuietly(insertClub);
					DBUtil.closeQuietly(insertUser);
					DBUtil.closeQuietly(insertAdvisor);
					DBUtil.closeQuietly(insertStudent);	
					DBUtil.closeQuietly(insertStudentAdvisor);
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

	private void loadStudent(xyz.jhofmann1.cs320.model.student.Student student, ResultSet rs, int index) throws SQLException
	{
		student.setStudentIDNum(rs.getInt(index++));
		student.setStudentFirstName(rs.getString(index++));
		student.setStudentLastName(rs.getString(index++));
		String studentID = student.getStudentFirstName().substring(0, 1).toLowerCase() + student.getStudentLastName().toLowerCase();
		student.setStudentID(studentID);
		int[] majors = {rs.getInt(index++)};
		student.setMajors(majors);
		student.setStudentPic(rs.getString(index++));
		int[] act = {rs.getInt(index++), rs.getInt(index++)};
		student.setActivities(act);
		student.setGPA((double) rs.getFloat(index++));
		student.setDisplayGPA(rs.getBoolean(index++));
		student.setReviewed(rs.getBoolean(index++));
		student.setUsername(student.getStudentID());
		student.setPasswordPlain(student.getStudentFirstName()+student.getStudentLastName());
	}
	@Override
	public List<xyz.jhofmann1.cs320.model.student.Student> findStudentByUsername(String username) {
		return executeTransaction(new Transaction<List<xyz.jhofmann1.cs320.model.student.Student>>() {

			@Override
			public List<xyz.jhofmann1.cs320.model.student.Student> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null; 
				ResultSet resultSet = null;
				
				List<xyz.jhofmann1.cs320.model.student.Student> result = new ArrayList<xyz.jhofmann1.cs320.model.student.Student>();
				
				try
				{
					stmt = conn.prepareStatement(
							"SELECT * "
							+ "FROM STUDENTS "
							+ "WHERE USERNAME = ?"
							);
					
					stmt.setString(1, username);
					
					resultSet = stmt.executeQuery();
					
					Boolean found = false; 
					
					while(resultSet.next())
					{
						found = true;
						
						xyz.jhofmann1.cs320.model.student.Student student = null;
						try {
							student = new xyz.jhofmann1.cs320.model.student.Student();
						} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						loadStudent(student, resultSet, 2);
						
						result.add(student);
					}
					
					if(!found)
					{
						System.out.println("No student found with that username");
					}
					
				}
				finally
				{
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(conn);
				}
				return result;
			} 
			
		});
	}
			

}
