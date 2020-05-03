package com.javatrial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tester {
	
	public static final String USA_LANG_CODE="EN";
	public static final String USA_COUNTRY_CODE="USA";

	public static void main(String[] args) throws IOException  {
			System.out.println(getLocaleContentMap(Optional.empty(), Optional.empty()));
			System.out.println(getLocaleContentMap(Optional.of("FR"),Optional.of("CAN")));
			
			//IntStream integerStream=IntStream.rangeClosed(1, 20);
			List<Integer> integers=Arrays.asList(2,5,8,0,9,10,7);
			try {
				integers.stream().map(x-> 5/x).collect(Collectors.toList());
			}
			catch (ArithmeticException ex) {
				System.out.println("Exception Occured...can't Divide by Zero");
			}
			//Runtime runtime= Runtime.getRuntime();
			//System.out.println("==========="+runtime.availableProcessors());
			//System.out.println("-----------"+runtime.freeMemory());
			
			List<String> names= Arrays.asList("neeraj", "aditya", "avinash");
			//names.forEach(x->System.out.println(x));
			names.forEach(String::toUpperCase);
			
		/*
		 * int i=5; int j=0; try { int k= i/j; } catch(ArithmeticException e) { throw
		 * new RuntimeException("cant divide a number by zero"); }
		 */
			
			//integerStream.forEach(System.out::println);
			
		/*
		 * for(int i:integers) { System.out.print(i+" "); }
		 */
			System.out.println(" ");
			
			
			
			//integerStream.forEach(x-> System.out.println(x));
			//integerStream.forEach(x-> System.out.println(x));
		 File file = new
		 File("C:\\Users\\kumar\\Documents\\Imp\\important_stuff.txt");
		 
		 
		 
		 System.out.println("largest Line Length in file:: " +file.getName()+ "----"+getLargestLineInATextfile(file));
		 
			
		/*
		 * StringTokenizer tokenizer= new StringTokenizer(getLargestLineInAfile(file),
		 * ","); while(tokenizer.hasMoreElements()) {
		 * System.out.println("Values separated by , are:: "+tokenizer.nextElement()); }
		 */
			//IntStream parallelIntegerStream=IntStream.rangeClosed(1, 20);
			//parallelIntegerStream.parallel().forEach(x-> System.out.println(x));
	}
	
	
	
	
	
	
	private  static String  getLocaleContentMap(Optional<String> inputLanguageCode, Optional<String> inputCountryCode) {
		 return inputLanguageCode.isPresent() && inputCountryCode.isPresent() 
				 ? inputCountryCode.get()+"_" +inputLanguageCode.get():USA_COUNTRY_CODE+"_"+USA_LANG_CODE;
		 
		 //Map<String, String> LocalContentMap= service.getLocaleContentMap(application.getContryCode(), languageCode);
	}

	private  static String getLargestLineInATextfile(File file) throws IOException {
		
		try(BufferedReader reader= new BufferedReader(new FileReader(file));)
		
		{
			
			//using stream
			/*
			 * resultString= reader.lines().sorted((x,y)->
			 * y.length()-x.length()).findFirst().get(); resultString= resultString+
			 * ","+resultString.length();
			 */
			
			//the other one using stream
			return reader.lines()
					.max(Comparator.comparingInt(String::length))
					.get();
		}
		
		
		
		//conventional approach
		/*
		 * while(reader.readLine()!=null) {
		 * if(reader.readLine().length()>largestLine.length()) {
		 * largestLine=reader.readLine(); } }
		 */
		
		//return reader.lines().mapToInt(String::length).max().getAsInt();
		
		
	}
	
	
}
