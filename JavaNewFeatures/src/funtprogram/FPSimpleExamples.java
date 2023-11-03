package funtprogram;

import java.util.List;
import java.util.stream.Collectors;

public class FPSimpleExamples {

	public static void main(String[] args) {
		List<Integer> numList = List.of(2, 3, 7, 19, 4, 2, 12, 16, 17);
		// printEachNumber(numList);
		// printOddNumbers(numList);
		// printSqureofEvenNumbers(numList);
		// printSumOfEvenNumbers(numList);
		//printMaxOdd(numList);
		//printDistcintSortedNumbers(numList);
		//System.out.print(doubleTheList(numList));
		System.out.print(createTheListWithDistinctEvenNumberSquares(numList));
		
	}

	private static List<Integer> createTheListWithDistinctEvenNumberSquares(List<Integer> numList) {
		return numList.stream().
			   distinct().
		       filter(num->num %2 == 0).
		       map(num -> num * num).
		       collect(Collectors.toList());   
	}

	private static List<Integer> doubleTheList(List<Integer> numList) {
		return numList.stream().
				map(num->  num*num).
				collect(Collectors.toList());
		
	}

	private static void printDistcintSortedNumbers(List<Integer> numList) {
		numList.stream().distinct().sorted().forEach(System.out::println);
		
	}

	private static void printMaxOdd(List<Integer> numList) {
		int max = numList.stream().
				filter(a -> a % 2 != 0).
				reduce(0, (a, b) -> a > b ? a : b);

		System.out.printf("Max Odd : %d", max);

	}

	private static void printSumOfEvenNumbers(List<Integer> numList) {
		int sum = numList.stream()
				.filter(a -> a % 2 == 0)
				.reduce(0, (a, b) -> a + b);

		System.out.printf("Sum : %d", sum);

	}

	private static void printEachNumber(List<Integer> numList) {
		numList.stream().forEach(System.out::println);

	}

	private static void printOddNumbers(List<Integer> numbers) {

		System.out.println("Odd Numbers : ");
		numbers.stream().filter(number -> number % 2 != 0).forEach(System.out::println);

	}

	private static void returnOddNumbers(List<Integer> numbers) {
		
		  System.out.println("Odd Numbers : ");
		  List<Integer> retList = 
			  numbers.stream()
			       .filter(number -> number % 2 != 0)
			       .collect(Collectors.toList());
		  	    
		 System.out.printf("RetList : %s", retList);
	}
	
	
	private static void printSqureofEvenNumbers(List<Integer> numbers) {

		System.out.println("Square Of Odd Numbers : ");
		numbers.stream().
				filter(number -> number % 2 == 0).
				map(num -> num * num).
				forEach(System.out::println);

	}

}
