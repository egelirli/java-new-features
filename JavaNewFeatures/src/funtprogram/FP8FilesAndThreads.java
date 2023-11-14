package funtprogram;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FP8FilesAndThreads {

	public static void main(String[] args) {
		
		//listoAllOperations();
		//testFiles();
		testThreads();

	}


	private static void testThreads() {
		  
		//Old way
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				
				for (int i = 0; i < 10000; i++) {
					System.out.println("Thead: " + Thread.currentThread().getId() + ":" + i);	
				}
				 
				
			}
		};
		
		Thread thhread1 = new Thread(runnable);
		thhread1.start();

		Thread thhread2 = new Thread(runnable);
		thhread2.start();

		Runnable runnable1 = ()-> {
			IntStream.range(0, 10000).
			      forEach( i -> System.out.println("Functional Thead:" + Thread.currentThread().getId() + ":" + i));
			
			
//			for (int i = 0; i < 10000; i++) {
//				System.out.println("Functional Thead: " + Thread.currentThread().getId() + ":" + i);	
//			}			
		};
		
		Thread thhread3 = new Thread(runnable1);
		thhread3.start();

		
	}


	
	
	private static void listoAllOperations() {
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices",
				"AWS", "PCF","Azure", "Docker", "Kubernetes");

		//courses.replaceAll( str -> str.toUpperCase()); //Error java.lang.UnsupportedOperationException
		
		List<String> modifyableCourses = new ArrayList<String>(courses);
		
		modifyableCourses.replaceAll(str -> str.toUpperCase());
		System.out.println("modifyableCourses - after replace All : " + modifyableCourses);
		
		
		modifyableCourses.removeIf(course -> course.length()<6);
		System.out.println("modifyableCourses- after Remove ıf : " + modifyableCourses);
		
	}
	
	private static void testFiles() {
		
		try {
			
			 String userDirectory = FileSystems.getDefault()
				        .getPath("")
				        .toAbsolutePath()
				        .toString();
			System.out.println("In testFies : Current Directory: " + userDirectory);
			
			
			System.out.println("List Directories: ");
			Files.list(Paths.get("."))
				  .filter(Files::isDirectory)
			      .forEach(System.out::println);
			
			System.out.println("List Words in file.txt: ");
			Files.lines(Paths.get("file.txt"))
			      .map(str -> str.split(" "))
			      .flatMap(Arrays::stream)
			      .distinct()
			      .sorted()
			      .forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
