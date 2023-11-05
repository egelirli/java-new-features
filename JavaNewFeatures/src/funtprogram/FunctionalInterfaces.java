package funtprogram;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FunctionalInterfaces {

	public static void main(String[] args) {
		List<Integer> numList = List.of(2, 3, 7, 19, 4, 2, 12, 16, 17);
		exampleFunctions();
		//testSumFunction(numList);
		//passFunctionAsParam(numList);
		//exampleSupplierFunction();
		
	}

	private static void exampleSupplierFunction() {
		//NoInput Return Something
		
		Supplier<Integer> randomIntSupplier = ()-> 2;
		Supplier<Integer> randomIntSupplier2 = ()-> {
			Random rand = new Random();
			return rand.nextInt();
		};
		
		System.out.println(randomIntSupplier2.get());
		
		
	}

	private static void exampleFunctions() {
		
		Predicate<Integer> isEvenPred = x -> x % 2 == 0;
		Function<Integer, String> functionReturnsString = x -> x+"";
		Function<? super Integer, ? extends Integer> functionSquare = x->x*x;
		Function<? super Integer, ? extends Integer> functionCube = x->x*x*x;
		
		Consumer<Integer> sysoutCons = x -> System.out.print(x);
		BinaryOperator<Integer>  sumBinary = (x,y) -> x+y;
		
		
		UnaryOperator<Integer> unaryOper = x -> x *2;
		System.out.println("unaryOper : "  + unaryOper.apply(10));
		
		BiPredicate<Integer, Integer> biPredicateGreater = (x,y)-> x > y;
		System.out.println("BiPredicate 3, 4 : " +  biPredicateGreater.test(3, 4));  
		
		

	}

	private static void passFunctionAsParam(List<Integer> numList) {
		
		
		
		List<Integer>  squaredNumbers  =  mapWithFunction(numList, x-> x*x);
		List<Integer>  cubedNumbers  =  mapWithFunction(numList, x-> x*x*x);
		
	}
	
	private static List<Integer> mapWithFunction(List<Integer> numList,
											Function<? super Integer, ? extends Integer>  funct) {
		
		
		return numList.stream()
		.map(funct)
		.collect(Collectors.toList());
		
	}
	
	
	private static void testSumFunction(List<Integer> numList) {
		
		BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
		
		BinaryOperator<Integer> sumBinaryOperator1 = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				// TODO Auto-generated method stub
				return t+u;
			}



			
		};
		
		numList.stream().
				reduce(0, sumBinaryOperator1);
				
	}


	
}
