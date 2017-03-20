package xyz.jhofmann1.cs320.controller.advisor;

import xyz.jhofmann1.cs320.model.advisor.AdvisorHome;

//Controller for the guessing game.
public class AdvisorHomeController {
	private AdvisorHome model;
	private int numStudents;

	//Set the model.
	  
	//@param model the model to set
	public void setModel(AdvisorHome model) {
		this.model = model;
	}

	//Setting the number of students and creating all lists
	//most of these methods should be done in the controller, not the model
	public void startGame() {
		model.setNumStudents(numStudents);
		model.createFirstNameList();
		model.createLastNameList();
		model.createIDList();
		model.createEmailList();
	}

	//set the number of students if numStudents is null
	public void setNumStudents() {
		numStudents = model.getNumStudents();
		model.setNumStudents(numStudents);
	}
}
