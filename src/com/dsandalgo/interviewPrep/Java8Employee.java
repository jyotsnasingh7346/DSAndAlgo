package com.dsandalgo.interviewPrep;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Employee {

	public static void main(String[] args) {
		
		// * Iterate through & modify a map
		Map<String, String> input = new HashMap<>();
		input.put("capital of india", "delhi");
		input.put("capital of maha", "mumbai");
		input.put("capital of up" , "prayagraj");
		
		// Change the value for capital of up
		input.computeIfPresent("capital of up", (key, value) -> "lucknow");
		input.entrySet().iterator().forEachRemaining(System.out::println);
		
		// Now, add a new key, value pair
		input.computeIfAbsent("capital of gujarat", (value) -> "ahmedabad");
		input.entrySet().iterator().forEachRemaining(System.out::println);
		
		
		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee("Vijay", 10, 100, LocalDate.of(2021, 01, 15), true, 20));
		emp.add(new Employee("Kabir", 40, 400, LocalDate.of(2022, 04, 18), false, 20));
		emp.add(new Employee("Rahul", 30, 300, LocalDate.of(2022, 03, 27), true, 30));
		emp.add(new Employee("Arjun", 50, 500, LocalDate.of(2020, 07, 31), false, 40));
		emp.add(new Employee("Jagga", 20, 200, LocalDate.of(2023, 07, 12), true, 40));
		
		// 1. Find highest paid employee
		String name2 = emp.stream()
							.sorted(Comparator.comparingInt(Employee::getSalary).reversed())
							.findFirst()
							.map(e -> e.getName())
							.get();
		System.out.println("Highest paid employee : " + name2);
		
		// Solution 2 for highest paid employee
		String name3 = emp.stream()
							.sorted((emp1, emp2) -> emp2.getSalary() - emp1.getSalary())
							.findFirst()
							.map(Employee::getName)
							.get();
		System.out.println("Highest paid employee : " + name3);
		
		// Solution 3 for highest paid employee
		String name4 = emp.stream()
							.collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)))
							.get()
							.getName();
		System.out.println("Highest paid employee : " + name4);
		
		// 2. Find emp name with 3rd largest salary : (sort, skip, findFirst)
		String name = emp.stream()
			.sorted(Comparator.comparingInt(Employee::getSalary).reversed())
			.skip(2)
			.findFirst()
			.map(Employee::getName)
			.get();
		System.out.println("Employee with 3rd largest salary : " + name);
		
		// Solution 2 for 3rd largest salaried employee
		String name1 = emp.stream()
					.sorted((emp1, emp2) -> emp2.getSalary() - emp1.getSalary())
					.skip(2)
					.findFirst()
					.map(Employee::getName)
					.get();
		System.out.println("Employee with 3rd largest salary : " + name1);
		
		// 3. Fetch top 3 salaried employee details (limit)
		System.out.println("Top 3 salaried employees : ");
		emp.stream()
			.sorted(Comparator.comparingInt(Employee::getSalary).reversed())
			.limit(3)
			.map(e -> e.getName() + " : " + e.getSalary())
			.forEach(t-> System.out.print(t));	//.collect(Collectors.toList());
		System.out.println();
		
		// 4. Fetch all employees having salary less than the 3rd highest salary : skip the 1st 3
		List<String> lessThan3rdHighest = emp.stream()
			.sorted(Comparator.comparingInt(Employee::getSalary).reversed())
			.skip(3)
			.map(e -> e.getName() + " : salary=" + e.getSalary())
			.collect(Collectors.toList());
		System.out.println(lessThan3rdHighest);
		
		// 5. sort list of employees based on their age and then salary
		List<String> collectt = emp.stream()
			.sorted(Comparator.comparingInt(Employee::getAge).thenComparing(Employee::getSalary))
			.map(e -> e.getName()+ " : age=" + e.getAge() + " : salary=" + e.getSalary())
			.collect(Collectors.toList());
		System.out.println(collectt);
		
		// 6. List of employees who joined after 2022
		List<String> collectt1 = emp.stream()
			.filter(i -> i.getDoj().isAfter(LocalDate.ofYearDay(2022, 01)) )
			.map(Employee::getName)
			.collect(Collectors.toList());
		System.out.println(collectt1);
		
		// 7. Find all the active employees, sorted by age
		List<String> collect1 = emp
			.stream()
			.filter(Employee::isActive)
			.sorted((emp1, emp2) -> emp1.getAge() - emp2.getAge())
			.map(e -> e.getName() + " : age=" + e.getAge())
			.collect(Collectors.toList());
		System.out.println(collect1);
		
		// 8. Group employees based on their pinCodes
				Map<Integer, List<Employee>> collect = emp
				.stream()
				.collect(Collectors.groupingBy(e -> e.getPinCode()));
		System.out.println(collect);
		
		// 9. Write the same code using java stream api

		/*
		 * for (Book book : books) {
				if (book.isInPrint()) {
					library.add(book);
				}
			}
		 */
		
		// List<Book> library = books.stream().filter(Book::isInPrint).collect(Collectors.toList());
		
		
		// 10. Write the same code using java stream api
		
		/*
		 * 	List<PE> listOfPE = getProjects();
			List<PDTO> listOfPDTO = new ArrayList<PDTO>();
				for (PE pe : listOfPE) {
					listOfPDTO.add(pe.getId());
				}
		 */
		
		/*
		 * 	List<PDTO> listOfPDTO = listOfPE.stream()
		 * 									.map(pe -> pe.getId())
		 * 									.map(PDTO)::new)
		 * 									.collect(Collectors.toList());
		 * 		
		 */
								
		
		
		
		
	}

}
