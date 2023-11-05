package funtprogram;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FP04CustomClass {

	public static void main(String[] args) {
		List<Course> courses = List.of(
				new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), 
				new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000), 
				new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), 
				new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));

		// allMatch, noneMatch, anyMatch
		Predicate<Course> reviewScoreGreaterThan95Predicate 
			= course -> course.getReviewScore() > 95;

		Predicate<Course> reviewScoreGreaterThan90Predicate 
			= course -> course.getReviewScore() > 90;
			
		Predicate<Course> reviewScoreLessThan90Predicate 
			= course -> course.getReviewScore() < 90;

		System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
		
		System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));
		
		System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));
		
		System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));
		
		Comparator<Course> comparingByNoOfStudentsAndNoOfReviews 
					= Comparator.comparingInt(Course::getNoOfStudents)
								.thenComparingInt(Course::getReviewScore)
								.reversed();

		Comparator<Course> comparingByNoOfStudentsAndNoOfReviews2 
			= Comparator.comparingInt(Course::getNoOfStudents)
						.thenComparingInt(Course::getReviewScore);

		
		System.out.println(
				courses.stream()
				.sorted(comparingByNoOfStudentsAndNoOfReviews)
				.collect(Collectors.toList()));
		//[Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]
		
		System.out.println(
				courses.stream()
				.sorted(comparingByNoOfStudentsAndNoOfReviews)
				.limit(5)
				.collect(Collectors.toList()));
				
		System.out.println(
				courses.stream()
				     .takeWhile(course -> course.getReviewScore()>=95)
				     .collect(Collectors.toList()));
			//[Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96]

		System.out.println(
					courses.stream()
					     .dropWhile(course -> course.getReviewScore()>=95)
					     .collect(Collectors.toList()));				
	
		System.out.println( " Max By NoOfStudentsAndNoOfReviews " + 
			courses.stream().
				max(comparingByNoOfStudentsAndNoOfReviews));
		
		System.out.println( " Max By NoOfStudentsAndNoOfReviews  2 - " + 
				courses.stream().
					max(comparingByNoOfStudentsAndNoOfReviews2));
		
		
		//Find total number of student whoses courses scores greater than %95
		System.out.println(""
				+ "total number of student whoses courses scores greater than %95: " + 
		courses.stream()
		.filter(reviewScoreGreaterThan95Predicate)
		.mapToInt(Course::getNoOfStudents)
		.sum());
		//total number of student whoses courses scores greater than %95: 88000
		
		System.out.println(""
				+ "Average number of student whoses courses scores greater than %95: " + 
		courses.stream()
			.filter(reviewScoreGreaterThan95Predicate)
			.mapToInt(Course::getNoOfStudents)
			.average());
		//OptionalDouble[22000.0]	
		
		System.out.println(""
				+ "Count number of  courses scores greater than %95 of review: " + 
		courses.stream()
			.filter(reviewScoreGreaterThan95Predicate)
			.count());
		
		
		//////////////////////////////
		//
		//  GroupBy
		//
		///////////////////////////////
		System.out.println(" Grouping By Category : " + 
			courses.stream()
			        .collect(Collectors.groupingBy(Course::getCategory)));
		
		//{Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91], 
		// FullStack=[FullStack:14000:91], 
		// Microservices=[API:22000:97, Microservices:25000:96], 
		// Framework=[Spring:20000:98, Spring Boot:18000:95]}
		
		System.out.println(" Counts Of courses in each  Category : " + 
				courses.stream()
				        .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
		//Counts Of Groupes By Category : {Cloud=4, FullStack=1, Microservices=2, Framework=2}
		
		
		System.out.println(" Max review course in each  Category : " + 
				courses.stream()
				        .collect(Collectors.groupingBy(
				        				Course::getCategory, 
				        		        Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		//{Cloud=Optional[Azure:21000:99], 
		//FullStack=Optional[FullStack:14000:91], 
		//Microservices=Optional[API:22000:97], 
		//Framework=Optional[Spring:20000:98]}

		System.out.println(" Name of the course in each  Category : " + 
				courses.stream()
				        .collect(Collectors.groupingBy(
				        				Course::getCategory, 
				        		        Collectors.mapping(Course::getName, Collectors.toList())))
		 );
		 //{Cloud=[AWS, Azure, Docker, Kubernetes], 
		 // FullStack=[FullStack], 
		 // Microservices=[API, Microservices], 
		 // Framework=[Spring, Spring Boot]}

		
	 }
}
