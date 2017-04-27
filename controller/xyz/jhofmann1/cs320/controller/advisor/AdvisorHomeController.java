package xyz.jhofmann1.cs320.controller.advisor;

import xyz.jhofmann1.cs320.model.advisor.Advisor;

//Controller for the guessing game.
public class AdvisorHomeController {
	private Advisor model;

	//Set the model.
	  
	//@param model the model to set
	public void setModel(Advisor model) {
		this.model = model;
	}
}