package funtprogram;

import java.util.stream.LongStream;

public class Paralelizing {

	public static void main(String[] args) {
		
//		long tımeStarted = System.currentTimeMillis();
//		System.out.println("Huge range sum: " + LongStream.range(0, 1000000000).sum());
//		System.out.println("Time took: " +  ( System.currentTimeMillis() - tımeStarted));

		long tımeStarted1 = System.currentTimeMillis();
		System.out.println("PArallel Huge range sum: " + LongStream.range(0, 1000000000).parallel().sum());
		System.out.println("Time took parallel: " +  ( System.currentTimeMillis() - tımeStarted1));
		
		
	}
	
	
}
