package com.javatrial.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

public class SetDemo extends Thread {
	
	public static void main(String args[]) {
		SetDemo setdemo= new SetDemo();
		setdemo.start();
		SortedSet<String> sites = new TreeSet<>(); 
	    sites.add("practice"); 
	    sites.add("geeksforgeeks"); 
	    sites.add("zeal");
	    sites.add("quiz"); 
	    sites.add("code");
	    
	     
	    

	    System.out.println("Sorted Set: " + sites); 
	    System.out.println("First: " + sites.first()); 
	    System.out.println("Last: " + sites.last()); 
	    
	    BiConsumer<Integer, Integer> summationLambda= ( a,  b) -> System.out.println(a+ " " +b);
	    summationLambda.accept(50, 60);
	    
	   
	    
	    
	    Queue<String> queue = new PriorityQueue<>();
		queue.add("one");
		queue.add("two");
		queue.add("three");
		queue.add("four");
		System.out.println(queue);
			
		queue.remove();
		System.out.println(queue);
		queue.add("ninety99");
		System.out.println(queue);
		System.out.println("Queue poll:: "+queue.poll());
		System.out.println("Queue Peak:: "+queue.peek());
	
		
		System.out.println("Queue Size: " + queue.size());
		System.out.println("Queue Contains element 'two' or not? : " + queue.contains("two"));

		// To empty the queue
		queue.clear();
		
		List<String> names = new ArrayList<>(); 
		names.add("practice"); 
		names.add("geeksforgeeks"); 
		names.add("zeal");
		names.add("quiz"); 
		names.add("code");
	    
		
		
		//Collections.sort(names, Collections.reverseOrder());
		Collections.sort(names);
		int indexOfSearch=Collections.binarySearch(names, "quiz");
		System.out.println(names);
		System.out.println("zeal found at index::" +indexOfSearch);
		System.out.println("Sorted list:: "+names);
		

	}
}
