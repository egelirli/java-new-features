package funtprogram;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapEtc {
	
	 public static void main(String[] args) {
		  List<String> courses = List.of(
				   "Spring", "Spring Boot", "API" , "Microservices","AWS", 
				   "PCF","Azure", "Docker", "Kubernetes");
		  
		  createTuplesWithSameLength(courses);
	}

	private static void createTuplesWithSameLength(List<String> courses) {
		List<String> courses2 = List.of("Spring", "Spring Boot", "API" , "Microservices",
				"AWS", "PCF","Azure", "Docker", "Kubernetes");
		
		
		courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
		System.out.println("Tuples: " +
		  courses.stream().
			flatMap(course -> courses2.stream().map(course2 -> List.of(course,course2)))
			.filter(list -> !list.get(0).equals(list.get(1)))
			.filter(list -> list.get(0).length() == list.get(1).length())
			.collect(Collectors.toList())
		 ); 
				
	}
	
	
}
