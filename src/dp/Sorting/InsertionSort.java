package dp.Sorting;
/*
 * The algorithm takes one value at a time from the unsorted part of the array and puts it into the right place in the sorted part of the array,
 *  until the array is sorted.
 *  How it works:
	1. Take the first value from the unsorted part of the array.
	2. Move the value into the correct place in the sorted part of the array.
	3. Go through the unsorted part of the array again as many times as there are values.
 */
public class InsertionSort {
	private boolean greater(int value1, int value2) {
		return value1 > value2;
	}

	public void sort(int[] arr) {
		int size = arr.length;
		int temp, j;
		
		for (int i = 1; i < size; i++) {
			temp = arr[i];
			for (j = i; j > 0 && greater(arr[j - 1], temp); j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = temp;
		}
	}

	public static void main(String[] args) {
		int[] array = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };
		InsertionSort srt = new InsertionSort();
		srt.sort(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");

		}
	}
}
/*
1 2 3 4 5 6 7 8 9
*/