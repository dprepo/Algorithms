package dp.app.array;

/*
  Java program to find Maximum difference between two elements such that larger 
	element appears after the smaller number
	Input : arr = {2, 3, 10, 6, 4, 8, 1}
	Output : 8
	Explanation : The maximum difference is between 10 and 2.

	Input : arr = {7, 9, 5, 6, 3, 2}
	Output : 2
	Explanation : The maximum difference is between 9 and 7.
 */
public class MaxDiffTwoElement {

	public static void main(String[] args) {
		int arr[] = { 80, 2, 6, 3, 100 };
		int n = arr.length;
		// Function calling
		System.out.print("Maximum difference is " + maxDiff(arr, n));
	}

	/*
	 * The function assumes that there are at least two elements in array. The
	 * function returns a negative value if the array is sorted in decreasing order
	 * and returns 0 if elements are equal
	 */
	static int maxDiff(int arr[], int n) {
		// Initialize diff, current
		// sum and max sum
		int diff = arr[1] - arr[0];
		int curr_sum = diff;
		int max_sum = curr_sum;

		for (int i = 1; i < n - 1; i++) {
			// Calculate current diff
			diff = arr[i + 1] - arr[i];

			// Calculate current sum
			if (curr_sum > 0)
				curr_sum += diff;
			else
				curr_sum = diff;

			// Update max sum, if needed
			if (curr_sum > max_sum)
				max_sum = curr_sum;
		}

		return max_sum;
	}
}
