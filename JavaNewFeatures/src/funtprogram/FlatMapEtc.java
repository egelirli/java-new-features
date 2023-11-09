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

	private static void createTuplesWithSameLength(List<String> courses1) {
		List<String> courses2 = List.of("Spring", "Spring Boot", "API" , "Microservices",
				"AWS", "PCF","Azure", "Docker", "Kubernetes");
		
		System.out.println("Char stream 1: " );
			courses1.stream().
			     map(course -> course.split("")).
			     forEach(carr ->  System.out.println(Arrays.toString(carr)));
			     //collect(Collectors.toList())
//		);
				
		System.out.println("Char stream : " + 
		           courses1.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList())
		);

		
//		System.out.println("---------");
//		System.out.println("Tuples: " +
//				  courses1.stream().
//					flatMap(course -> courses2.stream().map(course2 -> List.of(course,course2)))
//		);
		
		System.out.println("---------");
		
		System.out.println("Tuples 2: " +
		  courses1.stream().
			flatMap(course -> courses2.stream().
					filter(course2 -> course2.length() == course.length()).
					   map(course2 -> List.of(course,course2))
			.filter(list -> !list.get(0).equals(list.get(1))))
			.collect(Collectors.toList())
		 ); 
		//.filter(list -> list.get(0).length() == list.get(1).length())
				
	}
	
	
}
