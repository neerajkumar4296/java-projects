package com.javatrial.polymorphism;

public class Vehicle {
	
	public String companyName= "mahindra";
	public String modelName="mhr057";
	static String tyre="MRF";
	static String musicSystem="SONY";
	
	
	public Vehicle() {
		System.out.println("creating vehicle object");
	}
	
	public Vehicle(String companyName, String modelName) {
		System.out.println("creating vehicle object with args");
		this.companyName= companyName;
		this.modelName = modelName;
	}



	public void run() {
		System.out.println("vehicle running");
	}

	/*
	 * public void hasGear() { System.out.println("vehicle has gears"); }
	 */
	
	public void run( String modelName, String companyName) {
		System.out.println("Vehicle running:: Commapany Name>>> " +companyName+ " model Name>> " +modelName+ " and tyre. ::"
	                       +tyre+ " running"+ " and having music system of:: " +musicSystem);
	}


}