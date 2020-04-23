package com.javatrial.collections;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;



public class Streams {
	
	private static final String UNDERSCORE="_";

	public static void main(String[] args) throws Exception {
		List<String> names = Arrays.asList("Neeraj", "Rahul", "Mainak", "Santu", "Vikash"
				                           , "Aarti", "Priyank", "Saibal", "Achalveer", "Arohi", "Jafar", "Aparna", "Ishank");
		
		//InetAddress localhost = InetAddress.getLocalHost(); 
		//System.out.println(localhost.getHostAddress()+" :: "+localhost.getCanonicalHostName()+" :: "+localhost.getHostName() );
		
		;
		getNameStartingWithZ(names);
		sortNameByLength(names);
		System.out.println("started sequential stream:: " +LocalDateTime.now().atZone(ZoneId.of("Asia/Kolkata")));
		names.stream().forEach(Streams::show);
		System.out.println("ended sequential stream:: " +LocalDateTime.now().atZone(ZoneId.of("Asia/Kolkata")));
		System.out.println(" ");
		System.out.println("started parallel stream:: " +LocalDateTime.now().atZone(ZoneId.of("Asia/Kolkata")));
		names.parallelStream().sequential().forEach(Streams::show);
		System.out.println("ended parallel stream:: " +LocalDateTime.now().atZone(ZoneId.of("Asia/Kolkata")));
	}
	private static String getNameStartingWithZ(List<String> names) {
		//defining a predicate and passing it to stream.filter()
				Predicate<String> checkerStartignWithZ= name-> name.toUpperCase().startsWith("Z");
				String namesJoined= names.stream().reduce((str1, str2)-> str1.concat(UNDERSCORE).concat(str2) ).get();
				System.out.println("joined names:: " +namesJoined);
				String nameStartingWithZ= 
						 names.stream()
						.filter(checkerStartignWithZ)
						.findAny()
						//.orElse("no user found with name starting from Z")
						//.orElse(System.getProperties().getProperty("user.name", "Neeraj Kumar"));
						.orElseGet(()-> getDefaultUserFromSystem() );
						//.orElseThrow(ArithmeticException::new);
				        //.orElseThrow(IllegalArgumentException::new);
				        System.out.println("user name starting with z :: " +nameStartingWithZ);
		return nameStartingWithZ;
		
	}
	private static String getDefaultUserFromSystem() {
		return "no user could be found in the list...returning the system user:: "+System.getProperties().getProperty("user.name", "no user could be found from the system as well");
	}
	
	private static void show(String value) {
		System.out.println("showing the value:: " +value.toUpperCase()+" by thread "+Thread.currentThread());
	}
	
	private static List<String> sortNameByLength(List<String> values) {
		Comparator<String> namesSortedByLengthLambda= (name1, name2)-> { return name1.length()-name2.length(); };
		//BiFunction<String, String, Integer> sortNamesOfSameLength= (name1, name2)->  name1.length()+name2.length();
		
		List<String> namesSortedByLength= values.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
		System.out.println("names sorted by length :: " +namesSortedByLength);
		return namesSortedByLength;
	}


}
