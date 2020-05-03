package com.javatrial.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import com.javatrial.model.Employee;

public class MapDemo {
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		// System.out.println("Employee3:: "+getEmployeeMap().get("emp3"));
		List<Employee> uniqueEmployeeList= getUniqueEmployees(getEmployeeMap());
		System.out.println("Unique Employess::"+uniqueEmployeeList+ "\nUnique Employee Size:: "+uniqueEmployeeList.size());
		//System.out.println("good salary employees:: " + getEmployeeWithGoodSalary(getEmployeeRawMap()));
		// System.out.println("Employees:: " +getEmployeeRawMap());
		System.out.println("********from a raw map************");
		Employee empWithMaxSalary= getMaxSalary(getEmployeeRawMap());
		System.out.println("Employee with maxm salary: " +empWithMaxSalary);
//		Map<String, Employee> sortedMap= new TreeMap<>();
//		sortedMap.putAll(getEmployeeRawMap());*/
		System.out.println("********from a generic map************");
		Employee employeeWithMaxSalary=getEmployeeWithMaxSalary(getEmployeeMap());
		System.out.println("Employee with maxm salary: " +employeeWithMaxSalary);
		
		System.out.println("******Sorted Map**********");
		Map<String, Employee> employeeMap= getSortedMap(getEmployeeMap());
		
		employeeMap.entrySet().stream().forEach(System.out::println);
		
		
		Comparator<Employee> employeeNameComp= new Comparator<Employee>() {
			
			@Override
			public int compare(Employee emp1, Employee emp2) {
				
				return emp1.getFirstName().compareTo(emp2.getFirstName());
			}
		};
		System.out.println("*****Sorting by key*****************");
		getEmployeeMap().entrySet()
						.stream()
						.sorted(Map.Entry.comparingByKey())
						.forEach(System.out::println);
		
		System.out.println("*****Sorting by value using comparator object*****************");
		getEmployeeMap().entrySet()
						.stream()
						.sorted(Map.Entry.comparingByValue(employeeNameComp))
						.forEach(System.out::println);
		
		System.out.println("*****Sorting by value using comparator passed as lambda exp*****************");
		getEmployeeMap().entrySet()
						.stream()
						.sorted(Map.Entry.comparingByValue((emp1, emp2)-> emp1.getFirstName().compareTo(emp2.getFirstName())))
						.forEach(System.out::println);
		
	}
	
	
	
	public static HashMap<String, Employee> getEmployeeMap() {

		HashMap<String, Employee> employeeMap = new HashMap<String, Employee>();
		employeeMap.put("emp5", new Employee(986845, "Neeraj", "Kumar", 34000));
		employeeMap.put("emp2", new Employee(976342, "Ravi", "Kumar", 36400));

		employeeMap.put("emp3", new Employee(904782, "Archana", "Rajput", 36000));
		employeeMap.put("emp4", new Employee(904782, "Archana", "Rajput", 36000));

		employeeMap.put("emp1", new Employee(924123, "Ajit", "Kumar", 29000));

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
	private static Employee getEmployeeWithMaxSalary(Map<String, Employee> employeeMap) {
		return employeeMap.values().stream().max((emp1, emp2)->emp1.getSalary()-emp2.getSalary()).get();
	}

	public static Employee getMaxSalary(Map empMap) {
		//empMap.values().stream().forEach(emp-> System.out.println(((Employee) emp).getSalary()));
		/*
		 * for(Object obj: empMap.values()) { System.out.println(((Employee)
		 * obj).getSalary()); }
		 */
		return  (Employee) empMap.values().stream().max((emp1, emp2)->  ((Employee) emp1).getSalary()-((Employee) emp2).getSalary()).get();
		
		
	}
	
	// sorting the map based on first name....we are using LinkedHashMap because it maintains the insertion order.....
	// if you use hashmap even if you sort it by using but when you put it in HashMap there is not gurantee that when you print the map you will get the element in the same 
	// order as was while inserting.
	private static Map<String, Employee> getSortedMap(Map<String, Employee> employeeMap){
		return getEmployeeMap().entrySet()
		.stream()
		.sorted(Map.Entry.comparingByValue((emp1, emp2)-> emp1.getFirstName().compareTo(emp2.getFirstName())))
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key, value)-> key, LinkedHashMap::new));
	}

}
