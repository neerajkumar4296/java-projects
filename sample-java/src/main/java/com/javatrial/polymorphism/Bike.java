package com.javatrial.polymorphism;

public class Bike extends Vehicle {

	// public String companyName;
	// public String modelName;
	
	static String musicSystem = "BOSE";

	

	public Bike() {
		System.out.println("creating Bike object");
	}

	public Bike(String companyName, String modelName) {
		super("", "");
		System.out.println("creating Bike object with args");
		this.companyName = companyName;
		this.modelName = modelName;
	}

	public void run() {

		 System.out.println("Bike running:: Commapany Name>>> " +this.companyName+
				  " model Name>> " +this.modelName+ " and music system from ::" +musicSystem+ " running"); 
				 

	}
	
	public void hasGear() {
		System.out.println("automatic gears");
	}

	 public void run(String companyName, String modelName) {
	  
	  System.out.println("running:: Commapany Name>>> " +companyName+
	  " model Name>> " +modelName+ " and music system from ::" +super.musicSystem+ " running"); }
	 

}
