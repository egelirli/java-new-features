package funtprogram;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComplexExamples {
   
	
	public static void main(String[] args) {

		
		List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));
		
		printTotalAges(users);
		executeReduceOnParallelizedStream(users);
		peekExample();
		
		
    }

	private static void peekExample() {
		System.out.println("In peekExample");
		
		List<String> result =
			Stream.of("one", "two", "three", "four")
	        .filter(e -> e.length() > 3)
	        .peek(e -> System.out.println("Filtered value: " + e))
	        .map(String::toUpperCase)
	        .peek(e -> System.out.println("Mapped value: " + e))
	        .collect(Collectors.toList());
	}

	private static void printTotalAges(List<User> users) {

//		int computedAges = 
//		  users.stream().
//		    reduce(0, (partialAgeResult, user) -> partialAgeResult + user.getAge());
		
	
		int result = 
				users.stream()
			   .reduce(
					    0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum
					  );
		System.out.println("Result : " + result);
				//assertThat(result).isEqualTo(65);
		
	}
	
	public static  void executeReduceOnParallelizedStream(List<User> users) {
		int	result = users
	      .parallelStream()
	      .reduce(
	        0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum);
		
		System.out.println("Result : " + result);
	}	
}
