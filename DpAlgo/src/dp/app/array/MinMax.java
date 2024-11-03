package dp.app.array;

import java.util.Scanner;

//The main method must be in a class named "MinMax".
public class MinMax {
 /*
 
 Take input an array A of size N and write a program to print maximum and minimum elements of the input. 
 The only line of the input would contain a single integer N that represents the length of the array 
 followed by the N elements of the input array A. 
 
 */

 static int[] arrElement(int A[]){
     int n = A.length;
     int max = Integer.MIN_VALUE;
     int min = Integer.MAX_VALUE;

     for(int i =0; i<n; i++){
         if(A[i]>max){
             max = A[i];
         }
         if(A[i]<min){
             min = A[i];
         }    
     }
     int result[] = {max , min};
     return result;
 }
 public static void main(String[] args) {
     Scanner scn = new Scanner(System.in);
     int n = scn.nextInt();
     int value[]= new int[n];

     for(int i = 0; i < n; i++){
         value[i] = scn.nextInt();
     }
     int result[] = arrElement(value);
     System.out.println(result[0] + " " + result[1]);
 }
}