package com.javatrial.seach;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] integers=   { 5,19,7,2, 68, 24, 8, 40, 64, 13, 96, 52, 29, 1 , 16, 43, 14, 91, 27, 36, 67, 4, 18, 72, 77, 23, 69, 22, 34};
		//linearSearchElement(integers, 22);
		searchBinaryElement(integers, 22);
	}

	// 0 1 2 3 4 5 6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28
	// 1 2 4 5 7 8 13 14 16 18 19 22 23 24 27 29 34 36 40 43 52 64 67 68 69 72 77 91 96 
	private static void searchBinaryElement(int[] integers, int searchElement) {
		
		Instant startTime= Instant.now();
		System.out.println("started	:: " +startTime);
		Arrays.sort(integers);
		
		for(int i:integers) {
			System.out.print(i+" ");
		}
		System.out.println("");
		int start= 0;
		int end= integers.length-1;
		int mid= (start+end)/2;
		
		if(searchElement>integers[start] && searchElement<integers[end]) {
		while(start<=end) {
			
			if(integers[mid]<searchElement) {
				start=mid+1;
				//System.out.println("in less than.....");
			}
			else if(integers[mid]==searchElement) {
				System.out.println("found the element :: "+searchElement+" at position " +mid);
				//System.out.println("returning.....");
				break;
			}
			else{
				end=mid-1;
				//System.out.println("in else...");
			}
			mid= (start+end)/2;
		}
		
		}
		else {
			System.out.println("could not find the element:: "+searchElement+ " in the input array of integers:: "
					+ "range of the values in the array are:: (" +integers[start]+", " +integers[end]+ ")");
		}
			
		Instant finishTime= Instant.now();
		System.out.println("finished :: " +finishTime);
		double execTime= Duration.between(startTime, finishTime).toNanos()/1000000;
		System.out.println("total execution time for binary search:: " +execTime+ " ms");
		
		
	}

	private static void linearSearchElement(int[] integers, int searchElement) {
		//long startTime= System.currentTimeMillis();
		Instant start= Instant.now();
		System.out.println("started	:: " +start);
		for(int i=0; i<=integers.length-1; i++) {
			if (integers[i]==searchElement) {
				System.out.println("found the element :: "+searchElement+" at position " +i);
			}
			
		}
		//long endTime= System.currentTimeMillis();
		Instant finish= Instant.now();
		System.out.println("finished :: " +finish);
		double execTime= Duration.between(start, finish).toNanos()/1000000;
		System.out.println("total execution time for linear search:: " +execTime+ " ms");
		
	}
	

}
