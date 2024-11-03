package dp.Sorting;
import java.util.ArrayList;
import java.util.Collections;
/*
 * Bucket sort is a sorting algorithm that separate the elements into multiple groups said to be buckets. 
 * Elements in bucket sort are first uniformly divided into groups called buckets, 
 * and then they are sorted by any other sorting algorithm. After that, elements are gathered in a sorted manner.
 * 	1. First, partition the range into a fixed number of buckets.
	2. Then, toss every element into its appropriate bucket.
	3. After that, sort each bucket individually by applying a sorting algorithm.
	4. And at last, concatenate all the sorted buckets.
 */
// Allowed values from 0 to maxValue.
public class BucketSort {

	public void sort(int[] arr, int maxValue) {
		int numBucket = 5;
		sort(arr, maxValue, numBucket);
	}

	public void sort(int[] arr, int maxValue, int numBucket) {
		int length = arr.length;
		if (length == 0)
			return;

		ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>(numBucket);

		// Create empty buckets
		for (int i = 0; i < numBucket; i++)
			bucket.add(new ArrayList<Integer>());

		int div = (int) Math.ceil((double) maxValue / (numBucket));

		// Add elements into the buckets
		for (int i = 0; i < length; i++) {
			if (arr[i] < 0 || arr[i] > maxValue) {
				System.out.println("Value out of range.");
				return;
			}

			int bucketIndex = (arr[i] / div);

			// Maximum value will be assigned to last bucket.
			if (bucketIndex >= numBucket)
				bucketIndex = numBucket - 1;

			bucket.get(bucketIndex).add(arr[i]);
		}

		// Sort the elements of each bucket.
		for (int i = 0; i < numBucket; i++) {
			Collections.sort(bucket.get(i));
		}

		// Populate output from the sorted subarray.
		int index = 0, count;
		for (int i = 0; i < numBucket; i++) {
			ArrayList<Integer> temp = bucket.get(i);
			count = temp.size();
			for (int j = 0; j < count; j++) {
				arr[index++] = temp.get(j);
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 34, 7, 99, 5, 23, 45, 88, 77, 19, 91, 100 };
		int maxValue = 100;
		BucketSort b = new BucketSort();
		b.sort(array, maxValue);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}

/*
1 5 7 19 23 34 45 77 88 91 99 100
 */