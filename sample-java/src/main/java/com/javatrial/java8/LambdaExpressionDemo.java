package com.javatrial.java8;

import java.time.LocalDateTime;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;


public class LambdaExpressionDemo {
	
	
	
	

	public static void main(String[] args) {
		
		Supplier<LocalDateTime> dateTimeSupplier= () -> LocalDateTime.now();
		
		System.out.println(dateTimeSupplier.get());
		
		
		
		Function<String, String> substringFunction = (str1) -> str1.substring(8,10);
		
		System.out.println(substringFunction.apply(dateTimeSupplier.get().toString()));
		
		BiFunction<String , String , String> formatterBifunction = (str1,str2)-> str1.substring(0, 2)+"_"+str2.substring(0, 2);
		String joinedValue= substringFunction.apply(formatterBifunction.apply("Dheeraj", "mukul"));
		//joinerBifunction.apply("Dheeraj", "mukul").
		System.out.println("Joined Value:: " +joinedValue);
		
		
		//String joinedValue2= joinerBifunction.andThen(lengthFunction);
		
		
		
		

	}

}
