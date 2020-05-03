package com.javatrial.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArraysOperation {

	public static void main(String[] args) {
		int[] ints=   { 5,19,7,2, 68, 24, 8, 40, 64, 13, 96, 52, 29,5, 24, 1 , 16, 43, 14, 91, 27,5, 36, 67, 4, 18, 72, 77, 23, 69, 22, 34};
		findDuplicate(ints);
		findFrequency(ints);
	}
	
	private static void findDuplicate(int[] integers) {
		
		//int[] uniqueInts= new int[integers.length];
		//int[] duplicateInts= new int[integers.length];
		
		        Arrays.sort(integers);
		        
		        //Set<Integer> duplicatesSet= new HashSet<>();
		        List<Integer> duplicates= new ArrayList<>();
				List<Integer> uniques= new ArrayList<>();
				
				int countDuplicate = 0;
				int countUnique = 0;
				
				
				for (int i=0; i<integers.length-1; i++) {
					if(integers[i]==integers[i+1]) {
						/*
						 * if(duplicates.add(integers[i])) { countDuplicate++; }
						 */
						duplicates.add(integers[i]);
					}
					
					else
					{
						uniques.add(integers[i]);
						 //System.out.println(integers[i]+" ");
						//uniqueInts[i]=integers[i];
						 countUnique++;
					}
						
					  
				}
				System.out.print("duplicates:: ");
				duplicates.stream().forEach((i)->System.out.print(i+" "));
				System.out.println("");
				System.out.print("uniques:: ");
				uniques.stream().forEach((i)->System.out.print(i+" "));
				for(Integer integer: duplicates) {
					int occurence=Collections.frequency(duplicates, integer);
					System.out.println(integer +" occurence " +(occurence+1));
				}
				/*
				 * Arrays.stream(uniqueInts).forEach(System.out::print);
				 * System.out.println(" ");
				 * Arrays.stream(duplicateInts).forEach(System.out::print);
				 */
				
				
		
	}
	
	private static void findFrequency(int[] integers) {
		 
		for(int i=0; i<integers.length; i++) {
			int count=0;
			for(int j=i+1; j<integers.length; j++) {
				if(integers[i]==integers[j]) {
					System.out.print(integers[j]+" ");
					count++;
				}
				
				
			}
			
		}
       
  
    }
		
	

}
