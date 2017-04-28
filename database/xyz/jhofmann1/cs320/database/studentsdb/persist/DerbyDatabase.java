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

import xyz.jhofmann1.cs320.model.student.Student;
import xyz.jhofmann1.cs320.model.main.Credentials;
import xyz.jhofmann1.cs320.model.advisor.Advisor;
import xyz.jhofmann1.cs320.model.main.Activity;
import xyz.jhofmann1.cs320.model.main.Major;
import xyz.jhofmann1.cs320.model.main.Minor;
import xyz.jhofmann1.cs320.model.main.Sport;
import xyz.jhofmann1.cs320.model.main.StudentAdvisor;

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
							"create table Activities (" +
							" 	activity_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	activity varchar(60)" +
							")"
						);
					
					stmt4.executeUpdate();
					
					System.out.println("Activities table created");
					
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
							"CREATE TABLE STUDENTS ("
							+ "STUDENT_ID int PRIMARY KEY NOT NULL "
							+ "generated always as identity (start with 1, increment by 1), "
							+ "STUDENTIDNUM int NOT NULL, "
							+ "YCPUSERNAME varchar(40) NOT NULL, "
							+ "LASTNAME varchar(40) NOT NULL, "
							+ "FIRSTNAME varchar(40) NOT NULL, "
							+ "STUDENTPIC varchar(255), "
							+ "MAJORID1 int NOT NULL, "
							+ "MAJORID2 int, "
							+ "MAJORID3 int, "
							+ "MINORID1 int, "
							+ "MINORID2 int, "
							+ "MINORID3 int, "
							+ "SPORTID1 int, "
							+ "SPORTID2 int, "
							+ "CLUBID1 int, "
							+ "CLUBID2 int, "
							+ "GPA float(52), "
							+ "DISPLAYGPA smallint, "
							+ "ISREVIEWED smallint, "
							+ "ISAPPROVED smallint, "
							+ "CONSTRAINT STUDENT_USERS_USERNAME_FK FOREIGN KEY (YCPUSERNAME) REFERENCES USERS (USERNAME), "
							+ "CONSTRAINT STUDENTS_MAJORS1___FK FOREIGN KEY (MAJORID1) REFERENCES MAJORS (MAJOR_ID), "
							+ "CONSTRAINT STUDENTS_MAJORS2___FK FOREIGN KEY (MAJORID2) REFERENCES MAJORS (MAJOR_ID), "
							+ "CONSTRAINT STUDENTS_MAJORS3___FK FOREIGN KEY (MAJORID3) REFERENCES MAJORS (MAJOR_ID), "
							+ "CONSTRAINT STUDENTS_MINORS1___FK FOREIGN KEY (MINORID1) REFERENCES MINORS (MINOR_ID), "
							+ "CONSTRAINT STUDENTS_MINORS2___FK FOREIGN KEY (MINORID2) REFERENCES MINORS (MINOR_ID), "
							+ "CONSTRAINT STUDENTS_MINORS3___FK FOREIGN KEY (MINORID3) REFERENCES MINORS (MINOR_ID)"
							+ ")"
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
				Major[] majorList;
				Minor[]	minorList;
				Sport[]	sportList;
				Activity[]	activityList;
				List<Credentials> userList;
				List<Advisor> advisorList;
				List<Student> studentList = null;
				List<StudentAdvisor> studentAdvisorList;
				
				try {
					majorList			= InitialData.getMajors();
					minorList			= InitialData.getMinors();
					sportList 			= InitialData.getSports();
					activityList		= InitialData.getClubs();
					userList			= InitialData.getUsers();
					advisorList 		= InitialData.getAdvisors();
					studentAdvisorList 	= InitialData.getStudentAdvisors();
					
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}
				try {
					studentList     	= InitialData.getStudents();
				} catch (NoSuchAlgorithmException | InvalidKeySpecException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				PreparedStatement insertMajor			= null;
				PreparedStatement insertMinor 			= null;
				PreparedStatement insertSport			= null;
				PreparedStatement insertActivity			= null;
				PreparedStatement insertUser			= null;
				PreparedStatement insertAdvisor			= null;
				PreparedStatement insertStudent     	= null;
				PreparedStatement insertStudentAdvisor 	= null;
				try {
					// must completely populate Authors table before populating BookAuthors table because of primary keys
					
					// must completely populate Books table before populating BookAuthors table because of primary keys
					
					insertMajor = conn.prepareStatement("insert into majors (major) values (?)");
					for (int i = 1; i < majorList.length; i++) {
						insertMajor.setString(1, majorList[i].getTitle());
						insertMajor.addBatch();
					}
					insertMajor.executeBatch();
					
					System.out.println("Majors table populated");					
//					
					// must completely populate Books table before populating BookAuthors table because of primary keys
					insertMinor = conn.prepareStatement("insert into minors (minor) values (?)");
					for(int i = 1; i < minorList.length; i++)
					{
						insertMinor.setString(1, minorList[i].getTitle());
					}
					insertMinor.executeBatch();
					
					System.out.println("Minors table populated");	
					
					insertSport = conn.prepareStatement("insert into sports (sport) values (?)");
					for (int i = 1; i < sportList.length; i++) {
						insertSport.setString(1, sportList[i].getTitle());
						insertSport.addBatch();
					}
					insertSport.executeBatch();
					
					System.out.println("Sports table populated");
					
					insertActivity = conn.prepareStatement("insert into activities (activity) values (?)");
					for (int i = 1; i < activityList.length; i++) {
						insertActivity.setString(1, activityList[i].getTitle());
						insertActivity.addBatch();
					}
					insertActivity.executeBatch();
					
					System.out.println("Activities table populated");
					
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
						insertAdvisor.setString(3, advisor.getUsername());
						//insertAdvisor.setString(3,  advisor.getEmail());
						insertAdvisor.addBatch();
					}
					insertAdvisor.executeBatch();
					
					System.out.println("Advisors table populated");
					
					insertStudent = conn.prepareStatement("insert into students ("
							+ "studentidnum, ycpusername, lastname, firstname, studentpic, "
							+ "majorid1, sportid1, clubid1, gpa, displaygpa, "
							+ "isreviewed"
							+ ") "
							+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
					for (Student student : studentList) {
//							insertAuthor.setInt(1, student.getStudentId());	// auto-generated primary key, don't insert this
						insertStudent.setInt(1, student.getStudentIDNum());
						insertStudent.setString(2, student.getUsername());
						insertStudent.setString(3, student.getLastName());
						insertStudent.setString(4, student.getFirstName());
						insertStudent.setString(5, student.getStudentPic());
						insertStudent.setInt(6, student.getMajors()[0]);
						insertStudent.setInt(7, student.getSports()[0]);
						insertStudent.setInt(8, student.getClubs()[0]);
						insertStudent.setDouble(9, student.getGPA());
						insertStudent.setBoolean(10, student.isDisplayGPA());
						insertStudent.setBoolean(11, student.isReviewed());
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
						insertStudentAdvisor.setInt(1, studentAdvisor.getStudentID());
						insertStudentAdvisor.setInt(2, studentAdvisor.getAdvisorID());
						insertStudentAdvisor.addBatch();
					}
					insertStudentAdvisor.executeBatch();
					
					System.out.println("studentAdvisors table populated");
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertMajor);
					DBUtil.closeQuietly(insertMinor);
					DBUtil.closeQuietly(insertSport);
					DBUtil.closeQuietly(insertActivity);
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

	private void loadStudent(Student student, ResultSet rs, int index) throws SQLException
	{
		student.setStudentIDNum(rs.getInt(index++));
		student.setUsername(rs.getString(index++));
		student.setLastName(rs.getString(index++));
		student.setFirstName(rs.getString(index++));
		student.setStudentPic(rs.getString(index++));
		int[] majors = {rs.getInt(index++), rs.getInt(index++), rs.getInt(index++)};
		student.setMajors(majors);
		int[] minors = {rs.getInt(index++), rs.getInt(index++), rs.getInt(index++)};
		student.setMinors(minors);
		int[] sports = {rs.getInt(index++), rs.getInt(index++)};
		student.setSports(sports);
		int[] clubs = {rs.getInt(index++), rs.getInt(index++)};
		student.setClubs(clubs);
		student.setGPA(rs.getDouble(index++));
		student.setDisplayGPA(rs.getBoolean(index++));
		student.setReviewed(rs.getBoolean(index++));
		student.setApprovalState(rs.getBoolean(index++));
		student.setPasswordPlain(student.getFirstName()+student.getLastName());
	}
	@Override
	public List<Student> findStudentByUsername(String username) {
		return executeTransaction(new Transaction<List<Student>>() {

			@Override
			public List<Student> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null; 
				ResultSet resultSet = null;
				
				List<Student> result = new ArrayList<Student>();
				
				try
				{
					stmt = conn.prepareStatement(
							"SELECT * "
							+ "FROM STUDENTS "
							+ "WHERE YCPUSERNAME = ?"
							);
					
					stmt.setString(1, username);
					
					resultSet = stmt.executeQuery();
					
					Boolean found = false; 
					
					while(resultSet.next())
					{
						found = true;
						
						Student student = null;
						try {
							student = new Student();
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
