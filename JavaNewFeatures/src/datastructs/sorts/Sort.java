package datastructs.sorts;

import java.util.Arrays;

public class Sort {
     
	
	public static void main(String[] args) {
		
		//int[] arr = {5, 4, 3,9,1,8};
		//System.out.println("Arr: " + Arrays.toString(arr));
//		bubleSort(arr);
//		System.out.println("Arr after sort: " + Arrays.toString(arr));
//		selectionSort(arr);
//		System.out.println("Arr after sort: " + Arrays.toString(arr));
		//insertionSort(arr);
		//System.out.println("Arr after insertion sort: " + Arrays.toString(arr));
		
		//int[] arr1 = {1, 3, 7,8};
		//int[] arr2 = {2, 4, 5,6};
		//int[] arr1 = {5, 4, 3};
		 int[] arr = {2, 1, 9,8,7};
		 System.out.println("Arr before merge: " +Arrays.toString(arr));
		//System.out.println("Arr after merge: " + Arrays.toString(mergeArrays(arr1, arr2)));
		//System.out.println("Arr after merge sort: " + Arrays.toString(mergeSort(arr)));
		
		//System.out.println("Arr after combine: " + Arrays.toString(combineArraysAndPivot(9,arr1, arr2)));
		quickSort(arr);
		System.out.println("Arr after quick sort: " + Arrays.toString(arr));
		
		
	}
	
	


	public static void bubleSort(int[] arr ) {
		
		for(int i = arr.length - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				int tmp = arr[j];
				if(arr[j] > arr[j+1]) {
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
			
		}
		
	}
	
	
	private static void selectionSort(int[] arr) {
		
		for(int i = 0 ; i < arr.length; i++) {
			int mini = i; 
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] < arr[mini]) {
					mini = j;
				}
			}
			
			if(i != mini) {
				int tmp = arr[i];
				arr[i] = arr[mini];
				arr[mini] = tmp;
			}
		}	
		
	}

	private static void insertionSort(int[] arr) {
		
		for(int i = 0 ; i < arr.length; i++) {
			for(int j = i+1; j >= 1 && j < arr.length; j--) {
				//System.out.printf("i:%d j:%d arr[j]: %d  arr[i]: %d \n", i,j, arr[j],arr[i]);
				if(arr[j] < arr[j-1]) {
					int tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}else {
					break;
				}
			}
		}	
	}
	
	
//	public static int[] mergeSort(int[] arr) {
//		  
//		System.out.println("arr : " + Arrays.toString(arr));
//		
//		int midi = arr.length /2;
//		System.out.println("Midi : " + midi);
//		
//		int[] mergLeft = null, mergRight = null;
//		//LEFT
//		int[] left = Arrays.copyOfRange(arr, 0, midi);
//		System.out.println("left : " +  Arrays.toString(left));
//		if(left.length > 1) {
//			mergLeft =  mergeSort(left);
//		}
//	
//		//RIGHT
//		int[] right = Arrays.copyOfRange(arr, midi, arr.length);
//		System.out.println("right : " +  Arrays.toString(right));
//		if(right.length > 1) {
//			mergRight =  mergeSort(right);
//		}
//		
//		if(mergLeft != null)  && mergRight != null) {
//		      System.out.println("Merging  left : " +  Arrays.toString(mergLeft) 
//		                    + "right :" + Arrays.toString(mergRight));
//		      return mergeArrays(mergLeft, mergRight);	
//		}else {
//			return null;
//		}
//		
//	}
//	
	public static int[] mergeSort(int[] arr) {
		  
		System.out.println("arr : " + Arrays.toString(arr));
		if(arr.length == 1) return arr;
		
		int midi = arr.length /2;
		System.out.println("Midi : " + midi);
		//LEFT
		int[] left = Arrays.copyOfRange(arr, 0, midi);
		System.out.println("left : " +  Arrays.toString(left));
		int[] mergLeft =  mergeSort(left);
	
		//RIGHT
		int[] right = Arrays.copyOfRange(arr, midi, arr.length);
		System.out.println("right : " +  Arrays.toString(right));
		int[] 	mergRight =  mergeSort(right);
		
		return mergeArrays(mergLeft, mergRight);	
		
	}	
	private static int[] mergeArrays(int arr1[], int arr2[]) {
		System.out.println("");
		System.out.println("In mergeArrays  arr1 : " +  Arrays.toString(arr1) 
        						+ "arr2 :" + Arrays.toString(arr2));	
		
		int len =   arr1.length + arr2.length;
		int[] retArr = new int[len];
		
		for(int i =  0; i < len; i++) {
			retArr[i] = -1;
		}
		
		//System.out.println("retArr : " + Arrays.toString(retArr));
		//int len =  arr1.length <  arr2.length ? arr1.length : arr2.length;
		
		int i=0,j = 0, k =0;
		while(i < arr1.length && j < arr2.length) {
			if(arr1[i] < arr2[j] ) {
				retArr[k++]  = arr1[i++];
		     }else {
				retArr[k++]  = arr2[j++];
				
		     }
			 
			//System.out.printf("i : %d j: %d k : %d  -- ", i,j,k);
			//System.out.println("retArr : " + Arrays.toString(retArr));
		}
		
		for (int r = i; r < arr1.length; r++) {
			retArr[k++]  = arr1[r];
		}
		for (int r = j; r < arr2.length; r++) {
			retArr[k++]  = arr2[r];
		}
		
		System.out.println("in mergeArrays  retArr : " +  Arrays.toString(retArr)); 
		System.out.println("");
 		return retArr;
	}
	
	
//	public static int[] quickSort(int[] arr) {
//		System.out.println("");
//		System.out.println("in quickSort : " +  Arrays.toString(arr)); 
//		
//		if(arr.length > 1) {
//		  int pivVal = arr[0];
//		  //int pivi = rearrange(arr);
//		  int pivi = pivot(arr, 0, arr.length-1);
//		  
//
//		  int[] left = null;
//		  if(pivi > 0) {
//			  int[] leftToSort = Arrays.copyOfRange(arr, 0, pivi);  
//			  left =  quickSort(leftToSort);
//		  }
//		  
//		  int[] right = null;
//		  if(pivi < arr.length -1) {
//			  int[] rightToSort = Arrays.copyOfRange(arr, pivi+1, arr.length);
//			  right =  quickSort(rightToSort);
//		  }
//		  
//		  return combineArraysAndPivot(pivVal,left, right );  
//		  
//		}else {
//			return arr;
//		}
//		
//		
//	}
//	
//	private static int[] combineArraysAndPivot(int pivVal, int[] left, int[] right) {
//		
//		System.out.printf("In combineArraysAndPivot - pivVal: %d left : %s  right:%s\n",
//				       pivVal, Arrays.toString(left), Arrays.toString(right) );
//		
//		int  lenLeft = left != null ? left.length : 0;   
//		int  lenRight = right != null ? right.length : 0; 
//		
//		int[] retArray = new int[lenLeft + lenRight + 1];
//		if(left != null) {
//			System.arraycopy(left, 0, retArray, 0, lenLeft);
//		}
//		retArray[lenLeft] = pivVal;
//		if(right != null) {
//			System.arraycopy(right,0 , retArray, lenLeft+1, lenRight);
//		}
//
//		System.out.printf("In combineArraysAndPivot retArray - %s \n",
//			                                    Arrays.toString(retArray) );
//	
//		return retArray;
//	}

    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length-1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
    	
    	System.out.println("");
    	System.out.printf("quickSortHelper - left: %d right:%d array: %s\n", 
    			                          left, right, Arrays.toString(array));
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSortHelper(array, left, pivotIndex-1);
            quickSortHelper(array, pivotIndex+1, right);
        }
    }


    public static int pivot(int[] array, int pivotIndex, int endIndex) {
    	
    	System.out.println("");
    	System.out.printf("In pivot  arr: %s endIndex: %d\n", 
    						Arrays.toString(array),endIndex);
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);
    	System.out.printf("In pivot  return arr: %s swapIndex: %d\n", 
				Arrays.toString(array),swapIndex);

        return swapIndex;
    }
    
    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

}
