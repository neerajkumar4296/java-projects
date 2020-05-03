package com.javatrial.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String fileName = "objects.txt";
		// writing object to file needs the object to be serialized.

		/*
		 * FileOutputStream fos = new FileOutputStream(fileName); ObjectOutputStream oos
		 * = new ObjectOutputStream(fos); Student me = new Student(123, "Neeraj",
		 * 32500); oos.writeObject(me);
		 */

		// de-serialization of java objects
        // during de-serialization if the versionid didnt match with the one during serialization it will throw InvalidClassException.
		
		  FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois =
		  new ObjectInputStream(fis); Student readMe = (Student) ois.readObject();
		  System.out.println(readMe);
		 

	}

}
