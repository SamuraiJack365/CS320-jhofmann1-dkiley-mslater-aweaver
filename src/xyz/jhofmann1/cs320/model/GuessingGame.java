package xyz.jhofmann1.cs320.model;

import java.util.ArrayList;

public class GuessingGame {
	
	// set up variables
	private int numStudents;
	private ArrayList<String> firstNames;
	private ArrayList<String> lastNames;
	private ArrayList<Integer> ID;
	private ArrayList<String> email;
	
	// initialize variables
	public GuessingGame() {
		firstNames = new ArrayList<String>();
		lastNames = new ArrayList<String>();
		ID = new ArrayList<Integer>();
		email = new ArrayList<String>();
	}
	
	// set number of students
	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}
	
	// get number of students
	public int getnumStudents() {
		return numStudents;
	}
	
	// populate the first name list
	public void createFirstNameList() {
		for(int i = 0; i < numStudents; i++) {
			firstNames.add("Joe " + i);
		}
	}
	
	// populate the last name list
	public void createLastNameList() {
		for(int i = 0; i < numStudents; i++) {
			lastNames.add("Smith");
		}
	}
	
	// populate the id list
	public void createIDList() {
		for(int i = 0; i < numStudents; i++) {
			ID.add(i);
		}
	}
	
	// populate the email list
	public void createEmailList() {
		for(int i = 0; i < numStudents; i++) {
			lastNames.add(getFirstName(i)+"@ycp.edu");
		}
	}
	
	// get the first name list
	public String getFirstName(int num) {
		return firstNames.get(num);
	}
	
	// get the last name list
	public String getLastName(int num) {
		return lastNames.get(num);
	}
	
	// get the id list
	public int getID(int num) {
		return ID.get(num);
	}
	
	// get the email list
	public String getEmail(int num) {
		return email.get(num);
	}
	
	// create and return the master list containing all of the students' information
	public ArrayList<String> getMasterList() {
		ArrayList<String> tempList = new ArrayList<String>();
		for(int i = 0; i < numStudents; i++) {
			tempList.add(getFirstName(i));
			tempList.add(getLastName(i));
			tempList.add(Integer.toString(getID(i)));
			tempList.add(getEmail(i));
		}
		return tempList;
	}
}
