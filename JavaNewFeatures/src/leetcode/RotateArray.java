package leetcode;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        rotate(nums1, k1);
        System.out.println("Test case 1: Rotated array: " + Arrays.toString(nums1));  // prints "Rotated array: [5, 6, 7, 1, 2, 3, 4]"

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        rotate(nums2, k2);
        System.out.println("Test case 2: Rotated array: " + Arrays.toString(nums2));  // prints "Rotated array: [3, 99, -1, -100]"

        int[] nums3 = {1, 2};
        int k3 = 3;
        rotate(nums3, k3);
        System.out.println("Test case 3: Rotated array: " + Arrays.toString(nums3));  // prints "Rotated array: [2, 1]"

        int[] nums4 = {1};
        int k4 = 0;
        rotate(nums4, k4);
        System.out.println("Test case 4: Rotated array: " + Arrays.toString(nums4));  // prints "Rotated array: [1]"

        int[] nums5 = {1, 2, 3, 4, 5, 6};
        int k5 = 6;
        rotate(nums5, k5);
        System.out.println("Test case 5: Rotated array: " + Arrays.toString(nums5));  // prints "Rotated array: [1, 2, 3, 4, 5, 6]"
        
        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1: Rotated array: [5, 6, 7, 1, 2, 3, 4]
            Test case 2: Rotated array: [3, 99, -1, -100]
            Test case 3: Rotated array: [2, 1]
            Test case 4: Rotated array: [1]
            Test case 5: Rotated array: [1, 2, 3, 4, 5, 6]
        */	
    }


	private static void rotate(int[] arr, int k) {
		
		System.out.println("");
		System.out.printf("rotate - Array: %s k:%d \n",  Arrays.toString(arr), k);
		   //Rotate the given array by n times toward right    
        for(int i = 0; i < k; i++){    
            int j, last;    
            //Stores the last element of array    
            last = arr[arr.length-1];    
            
            for(j = arr.length-1; j > 0; j--){    
                //Shift element of array by one    
                arr[j] = arr[j-1];    
            }    
            //Last element of array will be added to the start of array.    
            arr[0] = last;    
        }    
	}

	
	private static void rotateOLD(int[] arr, int k) {
		
		System.out.println("");
		System.out.printf("rotate - Array: %s k:%d \n",  Arrays.toString(arr), k);
		for (int i = 0; i < k; i++) {
			
			//int tmp = -10000;
			System.out.printf("i : %d \n",i);
			for(int j=k+i; j < arr.length+k; j += k ) {
				   int l = j%(arr.length);
				   int tmp = arr[l];
				   System.out.printf("  j : %d l:%d tmp: %d\n",j,l, tmp);
				   arr[l]  = arr[i];
				   arr[i] = tmp;
			 }
			
		}
	}
	
}
