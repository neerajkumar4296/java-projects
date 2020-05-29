package com.java.datastructure;

public class Array {
	private int[] items;
	private int count;

	public Array(int size) {
		this.items = new int[size];
	}

	void insert(int item) {
		// finding if the array is full, if yes increase the size of array and copy the elements into the bigger array
		if (items.length == count) {
			int[] newItems = new int[count + 1];

			for (int i = 0; i < count; i++) {
				newItems[i] = items[i];
			}
			items = newItems;
		}

		// adding the item to the end of an array
		items[count] = item;
		count++;
	}
	
	void removeAt(int index) {
		
		//checking if index passed is beyond the range of array
		if(index<0 || index>=count) {
			throw new IllegalArgumentException("Index out of bounds");
		}
		
		//left shift of the element after removal.
		for(int i=index; i<count; i++) {
			
			if(count==i+1) {
				count--;
			}
			else {
				items[i]= items[i+1];
				count--;
			}
			
		}
		
		
	}

	int length() {
		return items.length;
	}

	void print() {
		for (int i = 0; i < count; i++) 
			System.out.print(items[i]+" ");
	}

}
Predicate<String> ifNameStartsWithKAndOfLength5= name-> name.startsWith("Z") && name.length()==5;
		Predicate<String> ifNameStartsWithKAndOfLength5Not= ifNameStartsWithKAndOfLength5.negate();
    
    package com.java.datastructure;

import java.util.Arrays;


public class ArraysDemo {

	public static void main(String[] args) {
		int[] numbers= new int[3];
		
		String[] names= new String[3];
		System.out.println("printing array:: " +numbers);
		System.out.println("elements in the array:: " +Arrays.toString(numbers));
		
		System.out.println("printing array:: " +names);
		System.out.println("elements in the array:: " +Arrays.toString(names));
		
		Array array= new Array(3);
		array.insert(7);
		array.insert(45);
		array.insert(89);
		
		
		System.out.println("size of array initially:: " +array.length());
		
		array.insert(25);
		System.out.println("inserted an element:: ");
		System.out.println("size of array now:: " +array.length());
		array.print();
		
		array.removeAt(3);
		System.out.println("\nremoving an element:: ");
		System.out.println("size of array after removing an element:: " +array.length());
		array.print();
		
		array.insert(29);
		array.insert(29);
		array.insert(29);
		array.insert(29);
		array.insert(29);
		System.out.println("\ninserting five elements:: ");
		System.out.println("size of array after five inserts:: " +array.length());
		array.print();
		
		
		
		
	}

}
