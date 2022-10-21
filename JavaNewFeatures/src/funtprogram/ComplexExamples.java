package funtprogram;

import java.util.Arrays;
import java.util.List;

public class ComplexExamples {
   
	
	public static void main(String[] args) {

		
		List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));
		
		printTotalAges(users);
		executeReduceOnParallelizedStream(users);
		
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
