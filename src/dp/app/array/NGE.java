package dp.app.array;

// next greater elements in a given array
/*
	Input: arr[] = [ 4 , 5 , 2 , 25 ]
	Output:  	   4      –>   5
	               5      –>   25
	               2      –>   25
	               
	               25     –>   -1
	Explanation: except 25 every element has an element greater than them present on the right side
	
	Input: arr[] = [ 13 , 7, 6 , 12 ]
	Output:  		13      –>    -1
	                7       –>     12
	                6       –>     12
	               12      –>     -1
	Explanation: 13 and 12 don’t have any element greater than them present on the right side
 * 
 */
public class NGE {

	 /* Display Array element and NGE pair for all elements of arr[] of size n */
   static void printNGE(int arr[], int n)
   {
       int next, i, j;
       for (i = 0; i < n; i++) {
           next = -1;
           for (j = i + 1; j < n; j++) {
               if (arr[i] < arr[j]) {
                   next = arr[j];
                   break;
               }
           }
           System.out.println(arr[i] + " -- " + next);
       }
   }

   public static void main(String args[])
   {
       int arr[] = { 11, 13, 21, 3 };
       //             i  i+1 .....n
       //                j........n
       int n = arr.length;
       printNGE(arr, n);
   }
}
