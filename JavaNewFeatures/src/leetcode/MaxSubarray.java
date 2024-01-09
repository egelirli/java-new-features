package leetcode;

import java.util.Arrays;

public class MaxSubarray {

    public static void main(String[] args) {
//        int[] inputCase0 = {1, -2, -3,};
//        int result0 = maxSubarray(inputCase0);
//        System.out.println("Example 0: Input: " + Arrays.toString(inputCase0) + "\nResult: " + result0); 
    	
    	
        // Example 1: Simple case with positive and negative numbers
        int[] inputCase1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = maxSubarray(inputCase1);
        System.out.println("Example 1: Input: " + Arrays.toString(inputCase1) + "\nResult: " + result1);  

        // Example 2: Case with a negative number in the middle
        int[] inputCase2 = {1, 2, 3, -4, 5, 6};
        int result2 = maxSubarray(inputCase2);
        System.out.println("Example 2: Input: " + Arrays.toString(inputCase2) + "\nResult: " + result2); 

        // Example 3: Case with all negative numbers
        int[] inputCase3 = {-1, -2, -3, -4, -5};
        int result3 = maxSubarray(inputCase3);
        System.out.println("Example 3: Input: " + Arrays.toString(inputCase3) + "\nResult: " + result3); 

        // Example 4: Case with all positive numbers
        int[] inputCase4 = {1, 2, 3, 4, 5};
        int result4 = maxSubarray(inputCase4);
        System.out.println("Example 4: Input: " + Arrays.toString(inputCase4) + "\nResult: " + result4); 

        // Example 5: Case with alternating positive and negative numbers
        int[] inputCase5 = {1, -1, 1, -1, 1};
        int result5 = maxSubarray(inputCase5);
        System.out.println("Example 5: Input: " + Arrays.toString(inputCase5) + "\nResult: " + result5); 
        
        /*
            EXPECTED OUTPUT:
            ----------------
            Example 1: Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
            Result: 6
            Example 2: Input: [1, 2, 3, -4, 5, 6]
            Result: 13
            Example 3: Input: [-1, -2, -3, -4, -5]
            Result: -1
            Example 4: Input: [1, 2, 3, 4, 5]
            Result: 15
            Example 5: Input: [1, -1, 1, -1, 1]
            Result: 1
        */
        
    }
    //Example 1: Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4] 
	private static int maxSubarray(int[] arr) {
		int  maxTotal = Integer.MIN_VALUE;
		System.out.printf("arr: %s \n", Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("i: %d \n", i);
			//if(arr[i] > maxTotal) maxTotal = arr[i];
			
			for(int len = 1; len <= arr.length - i; len++) {
				System.out.printf("  len: %d \n", len);
				int sum = 0;
				for (int j = 0; j < len; j++) {
				     sum += arr[i+j];
					 System.out.printf("   j: %d  sum:%d\n", j, sum);
				}
				System.out.printf("   sum(i:%d len:%d): %d\n",i,len, sum);
			    if(sum > maxTotal) 
			    	 maxTotal =  sum;	
			    System.out.printf("   maxTotal(i:%d len:%d): %d\n",i,len, maxTotal);
				
			}
		}
		
		return maxTotal;
	}	
    
    
	private static int maxSubarrayOLD(int[] arr) {
		int  maxTotal = Integer.MIN_VALUE;
		System.out.printf("arr: %s \n", Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("i: %d \n", i);
			//if(arr[i] > maxTotal) maxTotal = arr[i];

			for (int j = i; j < arr.length; j++) {
				 int sum = 0;
				 System.out.printf(" j: %d  \n", j);
				 for(int k = j; k < arr.length; k++) {
					 System.out.printf("   k: %d  sum:%d\n", k, sum);
				     sum += arr[k];
				 }
				 System.out.printf("   sum(j:%d ): %d\n",j,sum);
			     if(sum > maxTotal) 
			    	 maxTotal =  sum;	
			     System.out.printf("   maxTotal(j:%d): %d\n",j,maxTotal);
			}
			
		}
		
		return maxTotal;
	}	
	
	
}
