package com.javatrial.interview;

public class CodingChallenge {

	
	public static void printNumbersDivisibleBy() {
		StringBuilder divisibleByThreeAndFive = new StringBuilder();
		divisibleByThreeAndFive.append("Numbers divisible by both 3 and 5 between 1-100 are:: ");
		
		StringBuilder divisibleByThree = new StringBuilder();
		divisibleByThree.append("Numbers divisible by only 3 between 1-100 are:: ");
		StringBuilder divisibleByFive = new StringBuilder();
		divisibleByFive.append("Numbers divisible by only 5 between 1-100 are:: ");
		StringBuilder otherNumbers = new StringBuilder();
		otherNumbers.append("numbers not divisible by either 3 or 5 or both between 1-100 are:: ");
		
		
		for(int i=1; i<=100; i++) {
			if((i%3==0) && (i%5==0)) {
				divisibleByThreeAndFive.append(i+" ");
			}
			else if (i%3==0) {
				divisibleByThree.append(i+" ");
			}
			else if (i%5==0) {
				divisibleByFive.append(i+" ");
			}
			
			else
				otherNumbers.append(i+" ");
			
		}
		System.out.println(divisibleByThreeAndFive.toString());
		System.out.println(divisibleByThree.toString());
		System.out.println(divisibleByFive.toString());
		System.out.println(otherNumbers.toString());
		
		
	}
	
}
