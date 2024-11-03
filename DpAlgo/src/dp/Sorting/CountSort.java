package dp.Sorting;

import java.util.Arrays;

/*
 * 1. An array with values to sort.
   2. A 'countingSort' method that receives an array of integers.
   3. An array inside the method to keep count of the values.
   4. A loop inside the method that counts and removes values, by incrementing elements in the counting array.
   5. A loop inside the method that recreates the array by using the counting array,
 	 so that the elements appear in the right order.
 */
public class CountSort {
	public void sort(int[] arr, int lowerRange, int upperRange) {
		int i, j;
		int size = arr.length;
		int range = upperRange - lowerRange;
		int[] count = new int[range];

		for (i = 0; i < size; i++) {
			count[arr[i] - lowerRange]++;
			System.out.println(Arrays.toString(count));
		}
		
		System.out.println(Arrays.toString(count));

		j = 0;
		for (i = 0; i < range; i++) {
			for (; count[i] > 0; (count[i])--) {
				arr[j++] = i + lowerRange;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 23, 24, 22, 21, 26, 25, 27, 28, 21, 21 };
		CountSort b = new CountSort();
		b.sort(array, 20, 30);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}

/*
21 21 21 22 23 24 25 26 27 28
*/