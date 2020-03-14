package com.javatrial.model;



public class Passenger {

	private String firstName;
	private String lastName;
	private String source;
	private String destination;
	private String mobileNo;	
	private int noOfTicket;
	
	public Passenger() {
		super();
	}

	public Passenger(String firstName, String lastName, String source, String destination, String mobileNo,
			int noOfTicket) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.source = source;
		this.destination = destination;
		this.mobileNo = mobileNo;
		this.noOfTicket = noOfTicket;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getNoOfTicket() {
		return noOfTicket;
	}

	public void setNoOfTicket(int noOfTicket) {
		this.noOfTicket = noOfTicket;
	}

	@Override
	public String toString() {
		return "Passenger [firstName=" + firstName + ", lastName=" + lastName + ", source=" + source + ", destination="
				+ destination + ", mobileNo=" + mobileNo + ", noOfTicket=" + noOfTicket + "]";
	}


	
}
