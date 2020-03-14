package com.javatrial.polymorphism;

public class Bike extends Vehicle {

	// public String companyName;
	// public String modelName;
	
	static String musicSystem = "BOSE";

	public static void main(String args[]) {
		/// Vehicle vehicle= new Vehicle();
		// Bike bike = new Bike("FZ", "Yamaha");
		Vehicle v = new Bike();
		//Vehicle vehicle = new Vehicle();
		// Vehicle vehicleBike= new Bike("FZ", "Yamaha");
		// vehicle.run();
		// bike.run();
		// vehicleBike.run();
		

		v.run();

		/*
		 * System.out.println(" "); vehicle.run("", "");
		 */

	}

	public Bike() {
		super();
		System.out.println("in Bike");
	}

	public Bike(String companyName, String modelName) {
		super("", "");
		System.out.println("in Bike with args");
		this.companyName = companyName;
		this.modelName = modelName;
	}

	public void run() {

		 System.out.println("running:: Commapany Name>>> " +companyName+
				  " model Name>> " +modelName+ " and music system from ::" +musicSystem+ " running"); 
				 

	}

	 public void run(String companyName, String modelName) {
	  
	  System.out.println("running:: Commapany Name>>> " +companyName+
	  " model Name>> " +modelName+ " and music system from ::" +super.musicSystem+ " running"); }
	 

}
