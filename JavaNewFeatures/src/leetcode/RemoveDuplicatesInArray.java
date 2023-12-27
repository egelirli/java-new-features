package leetcode;

import java.util.Arrays;

public class RemoveDuplicatesInArray {

	 public static void main(String[] args) {

	        int[] nums1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
	        int newLength1 = removeDuplicates(nums1);
	        System.out.println("Test case 1: New length: " + newLength1);
	        System.out.println("Test case 1: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums1, 0, newLength1)));

	        int[] nums2 = {1, 1, 2};
	        int newLength2 = removeDuplicates(nums2);
	        System.out.println("Test case 2: New length: " + newLength2);
	        System.out.println("Test case 2: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums2, 0, newLength2)));

	        int[] nums3 = {-1, 0, 0, 0, 3, 3};
	        int newLength3 = removeDuplicates(nums3);
	        System.out.println("Test case 3: New length: " + newLength3);
	        System.out.println("Test case 3: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums3, 0, newLength3)));

	        int[] nums4 = {};
	        int newLength4 = removeDuplicates(nums4);
	        System.out.println("Test case 4: New length: " + newLength4);
	        System.out.println("Test case 4: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums4, 0, newLength4)));

	        int[] nums5 = {1, 1, 1, 1, 1};
	        int newLength5 = removeDuplicates(nums5);
	        System.out.println("Test case 5: New length: " + newLength5);
	        System.out.println("Test case 5: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums5, 0, newLength5)));
	
    }

	 
	 
	 public static int removeDuplicates(int arr[]){  
		 
		    System.out.println("Arr: " + Arrays.toString(arr));
		    int n = arr.length;
	        if (n==0 || n==1){  
	            return n;  
	        }    
	        int j = 0;//for next element  
	        for (int i=0; i < n-1; i++){  
	            if (arr[i] != arr[i+1]){  
	                arr[j++] = arr[i];  
	            }  
	        }  
	        arr[j++] = arr[n-1];  
	        return j;  
	    }  	 
	 
//	private static int removeDuplicates(int[] nums) {
//		int i = 0;
//		for (i = 0; i < nums.length; i++) {
//			  if(i+1 >= nums.length) break; 
//			  if(nums[i+1] == nums[i]) {
//				  removeElt(nums, i+1);
//			  }
//		}
//		
//		return i;
//	}
//	
//	
//	public static void removeElt( int [] arr, int remIndex ){
//	   System.out.printf("\nremoveElt -  remIndex: %d arr: %s\n",remIndex, Arrays.toString(arr));
//	   for ( int i = remIndex ; i < arr.length - 1 ; i++ ){
//		   System.out.println("i:" + i); 
//	      arr[ i ] = arr[ i + 1 ] ; 
//	   }
//	   
//	   System.out.printf("removeElt -  returns arr: %s\n\n", Arrays.toString(arr));
//	}
}
