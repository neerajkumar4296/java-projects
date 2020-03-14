package com.javatrial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.javatrial.model.Employee;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		// System.out.println("Employee3:: "+getEmployeeMap().get("emp3"));
		List<Employee> uniqueEmployeeList= getUniqueEmployees(getEmployeeMap());
		 System.out.println("Unique Employess::"+uniqueEmployeeList+ "\nUnique Employee Size:: "+uniqueEmployeeList.size() );
		//System.out.println("good salary employees:: " + getEmployeeWithGoodSalary(getEmployeeRawMap()));
		// System.out.println("Employees:: " +getEmployeeRawMap());
		getMaxSalary(getEmployeeRawMap());
	}

	public static HashMap<String, Employee> getEmployeeMap() {

		HashMap<String, Employee> employeeMap = new HashMap<String, Employee>();
		employeeMap.put("emp1", new Employee(986845, "Neeraj", "Kumar", 34000));
		employeeMap.put("emp2", new Employee(976342, "Ravi", "Kumar", 36400));

		employeeMap.put("emp3", new Employee(904782, "Archana", "Rajput", 36000));
		employeeMap.put("emp4", new Employee(904782, "Archana", "Rajput", 36000));

		employeeMap.put("emp5", new Employee(924123, "Ajit", "Kumar", 29000));

		employeeMap.put("emp6", new Employee(976435, "Prakash", "Kumar", 31500));
		employeeMap.put("emp7", new Employee(986439, "Sandhya", "Sharma", 32000));

		return employeeMap;

	}

	public static Map<String, Employee> getEmployeeRawMap() {

		Map employeeMap = new HashMap();
		employeeMap.put("emp1", new Employee(986845, "Neeraj", "Kumar", 34000));
		employeeMap.put("emp2", new Employee(976342, "Ravi", "Kumar", 36400));

		employeeMap.put("emp3", new Employee(904782, "Archana", "Rajput", 36000));
		employeeMap.put("emp4", new Employee(904782, "Archana", "Rajput", 36000));

		employeeMap.put("emp5", new Employee(924123, "Ajit", "Kumar", 29000));

		employeeMap.put("emp6", new Employee(976435, "Prakash", "Kumar", 31500));
		employeeMap.put("emp7", new Employee(986439, "Sandhya", "Sharma", 32000));

		return employeeMap;

	}

	public static List<Employee> getEmployeeWithGoodSalary(Map empMap) {
		List<Employee> empList = new ArrayList<Employee>();
		getEmployeeRawMap().forEach(new BiConsumer<String, Employee>() {

			@Override
			public void accept(String objKey, Employee emp) {
				if (((Employee) empMap.get(objKey)).getSalary() > 32000) {
					empList.add(emp);
				}

			}

		});
		return empList;
	}

	public static List<Employee> getUniqueEmployees(HashMap<String, Employee> employeeMap) {
		// List<Employee> uniqueEmployees=
		// extractEmployee(employeeMap).stream().filter(distinctByKey(Employee::getEmployeeId)).collect(Collectors.toList());
		return extractEmployee(employeeMap).stream().distinct().collect(Collectors.toList());

	}

	private static List<Employee> extractEmployee(HashMap<String, Employee> employeeMap) {
		Set<String> employeeKeys = employeeMap.keySet();
		 //List<Employee> employeeList= new ArrayList<Employee>();
		 List<Employee> employeeList= employeeKeys.stream().map(key-> (employeeMap.get(key))).collect(Collectors.toList());
		/*
		 * for (String empKey : employeeKeys) {
		 * employeeList.add(employeeMap.get(empKey)); }
		 */
		return employeeList;

	}


	public static int getMaxSalary(Map empMap) {
		empMap.values().stream().forEach(emp-> System.out.println(((Employee) emp).getSalary()));
		/*
		 * for(Object obj: empMap.values()) { System.out.println(((Employee)
		 * obj).getSalary()); }
		 */
		
		return 0;
		
	}
	
}
