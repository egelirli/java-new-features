package funtprogram;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamOfArrays {
    public static void main(String[] args) {
		
    	
    	System.out.println(" Stream.of : " + Stream.of(12,9,13,4,6,2,4,12,15));
    	//java.util.stream.ReferencePipeline$Head@7d417077
    	
    	 int[] numberArray = {12,9,13,4,6,2,4,12,15};
    	 System.out.println(" Arrays.stream : " + Arrays.stream(numberArray));
    	 //java.util.stream.IntPipeline$Head@2c8d66b2
    	 
    	 System.out.println("Sum " + Arrays.stream(numberArray).sum());
    	 System.out.println("Average " + Arrays.stream(numberArray).average());
    	 System.out.println("Min " + Arrays.stream(numberArray).min());
    	 
    	 
    	 System.out.println("IntStream.sum: " + IntStream.range(0, 10).sum());
    	 System.out.println("IntStream.sum: " + IntStream.rangeClosed(0, 10).sum());
    	 
    	 System.out.println("IntStream.iterate: " + IntStream.iterate(1, e -> e + 2).limit(10).sum()) ;
    	 
    	 IntStream.iterate(2, e -> e + 2).limit(10).peek(System.out::println).sum();
    	 
    	 System.out.println("IntStream.iterate 2* pow 2:");
    	 IntStream.iterate(2, e -> e * 2).limit(10).peek(System.out::println).sum();
    	 
    	 
    	 System.out.println("IntStream.toList:" +  
    			 		IntStream.iterate(2, e -> e * 2).limit(10).boxed().collect(Collectors.toList()));
    	 
    	 
    	 ////// Big Integer operations
    	 System.out.println("LongStream factorial: (1-10)" + LongStream.rangeClosed(1, 10).reduce(1, (x,y) -> x*y) );
    	 
    	 System.out.println("LongStream factorial: (1-50)" + 
    			 			LongStream.rangeClosed(1, 50).
    			 			mapToObj(BigInteger::valueOf). 
    			 			reduce(BigInteger.ONE, BigInteger::multiply ));
    	 
    	 
    	 
    	 
    	 
    	 
	}
}
