package xyz.jhofmann1.cs320.database.studentsdb.model;

public class Advisor {
	
	// set up variables
		private int advisor_Id;
		private String firstName;
		private String lastName;
		private String userName;
		//private String email;
		
		// initialize variables
		public Advisor() {

		}
		
		public void setAdvisorId(int advisor_Id) {
			this.advisor_Id = advisor_Id;
		}
		
		public int getId() {
			return advisor_Id;
		}
		
		// populate the first name list
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		public String getFirstName() {
			return firstName;
		}
		
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		// get the last name list
		public String getLastName() {
			return lastName;
		}
		
		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserName() {
			return userName;
		}
		
//		public void setEmail(String email) {
//			this.email = email;
//		}
//		
//		// get the email
//		public String getEmail() {
//			return email;
//		}

}
