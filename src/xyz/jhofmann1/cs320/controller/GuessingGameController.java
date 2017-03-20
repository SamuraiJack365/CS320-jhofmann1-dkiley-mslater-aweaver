package xyz.jhofmann1.cs320.controller;

import xyz.jhofmann1.cs320.model.GuessingGame;

//Controller for the guessing game.
public class GuessingGameController {
	private GuessingGame model;
	private int numStudents;

	//Set the model.
	  
	//@param model the model to set
	public void setModel(GuessingGame model) {
		this.model = model;
	}

	//Setting the number of students and creating all lists
	public void startGame() {
		model.setNumStudents(numStudents);
		model.createFirstNameList();
		model.createLastNameList();
		model.createIDList();
		model.createEmailList();
	}

	//set the number of students if numStudents is null
	public void setNumStudents() {
		numStudents = model.getnumStudents();
		model.setNumStudents(numStudents);
	}
}
