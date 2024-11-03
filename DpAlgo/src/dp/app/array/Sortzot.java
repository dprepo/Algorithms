package dp.app.array;
/*
 Problem Statement: Given an array consisting of only 0s, 1s, and 2s.
 Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) 
 and constant space)
 ex.
 Input:  nums = [2,0,2,1,1,0]
 Output : [0,0,1,1,2,2]
 
 */
//Java program to sort an array of 0s, 1s and 2s in a
//single pass

class Sortzot {

 // Sort the input array, the array is assumed to
 // have values in {0, 1, 2}
 static void sort012(int a[], int n)
 {
     int lo = 0;
     int hi = n - 1;
     int mid = 0, temp = 0;

     while (mid <= hi) {
         switch (a[mid]) {
             // If the element is 0
             case 0: {
                 temp = a[lo];
                 a[lo] = a[mid];
                 a[mid] = temp;
                 lo++;
                 mid++;
                 break;
             }
                 // If the element is 1
             case 1:
                 mid++;
                 break;
                 // If the element is 2
             case 2: {
                 temp = a[mid];
                 a[mid] = a[hi];
                 a[hi] = temp;
                 hi--;
                 break;
             }
         }
     }
 }

 /* Utility function to print array arr[] */
 static void printArray(int arr[], int n)
 {
     int i;
     for (i = 0; i < n; i++)
         System.out.print(arr[i] + " ");
     System.out.println("");
 }

 /*Driver function to check for above functions*/
 public static void main(String[] args)
 {
     int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
     int n = arr.length;
     sort012(arr, n);
     printArray(arr, n);
 }
}
