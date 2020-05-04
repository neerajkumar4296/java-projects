package com.javatrial.java8;

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



public class StreamsDemo {
	
	private static final String UNDERSCORE="_";

	public static void main(String[] args) throws Exception {
		List<String> names = Arrays.asList("Neeraj", "Rahul", "Mainak", "Santu", "Vikash"
				                           , "Aarti", "Priyank", "Saibal", "Achalveer", "Arohi", "Jafar", "Aparna", "Ishank");
		
		List<Integer> integers = Arrays.asList(22,46, 62,12, 21, 97, 56,64, 59, 10, 8, 7, 31, 38, 27, 75);
		
		//InetAddress localhost = InetAddress.getLocalHost(); 
		//System.out.println(localhost.getHostAddress()+" :: "+localhost.getCanonicalHostName()+" :: "+localhost.getHostName() );
		
		;
		Predicate<Integer> isEven= integer-> integer%2==0;
		boolean areAllNumbersEven= integers.stream().peek(integer->System.out.println(integer)).allMatch(isEven);
		System.out.println(areAllNumbersEven);
		
		// Integers summation different approaches
		Integer sumUsingIntegerClassMethod= integers.stream().peek(integer->System.out.print(integer)).reduce(0, Integer::sum);
		Integer sumOfNumbersSkipingFirstThree= integers.stream().skip(3).mapToInt(Integer::intValue).sum();
		Integer sumOfNumbersSkipingThree= integers.stream().skip(3).reduce(0, (integer1, integer2)-> integer1+integer2);
		Double averageOfNumbers= integers.stream().skip(3).mapToInt(Integer::intValue).average().getAsDouble();
		
		System.out.println("sumUsingIntegerClassMethod:: " +sumUsingIntegerClassMethod);
		System.out.println("sumOfNumbersSkipingFirstThree:: " +sumOfNumbersSkipingFirstThree);
		System.out.println("sumOfNumbersSkipingThree:: " +sumOfNumbersSkipingThree);
		System.out.println("averageOfNumbers:: " +Math.round(averageOfNumbers));
		
		
		getNameStartingWithZ(names);
		sortNameByLength(names);
		System.out.println("started sequential stream:: " +LocalDateTime.now().atZone(ZoneId.of("Asia/Kolkata")));
		names.stream().forEach(StreamsDemo::show);
		System.out.println("ended sequential stream:: " +LocalDateTime.now().atZone(ZoneId.of("Asia/Kolkata")));
		System.out.println(" ");
		System.out.println("started parallel stream:: " +LocalDateTime.now().atZone(ZoneId.of("Asia/Kolkata")));
		//parallel stream no guarantee of execution order
		names.parallelStream().forEach(StreamsDemo::show);
		// this will execute the stream sequentially...parallel stream is overridden
		//names.parallelStream().sequential().forEach(StreamsDemo::show);
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
		Comparator<String> namesSortedByLengthLambda= (name1, name2)-> name1.length()-name2.length();
		//BiFunction<String, String, Integer> sortNamesOfSameLength= (name1, name2)->  name1.length()+name2.length();
		System.out.println("names sorted by length using lambda :: ");
		List<String> namesSortedByLengthUsingLambda=values.stream().sorted(namesSortedByLengthLambda).collect(Collectors.toList());
		namesSortedByLengthUsingLambda.forEach(System.out::print);
		System.out.println("**********************************************");
		List<String> namesSortedByLength= values.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
		System.out.println("names sorted by length :: " +namesSortedByLength);
		return namesSortedByLength;
	}


}
