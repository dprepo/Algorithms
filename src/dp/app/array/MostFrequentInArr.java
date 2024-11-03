package dp.app.array;
/*
Moore’s Voting Algorithm is a space-efficient algorithm that works well when the most frequent element 
(or majority element) occurs more than n/2 times. It finds the majority element by counting votes. 
However, this algorithm only guarantees correctness if there is an element that occurs more than n/2  times.
*/
public class MostFrequentInArr {

	static int findCandidate(int[] arr, int n) {
		// using moore's voting algorithm to find the candidate
		int res = 0;
		int count = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i] == arr[res]) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				res = i;
				count = 1;
			}
		}
		return arr[res];
	}

	static boolean isMajority(int[] arr, int n, int candidate) {
		// check if candidate is actually the majority
		// element
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == candidate) {
				count++;
			}
		}
		return count > n / 2;
	}

	// Driver code
	public static void main(String[] args) {
		int arr[] = { 30, 30, 30, 40, 50, 40, 50,30 };
		int n = arr.length;
		int candidate = findCandidate(arr, n);
		if (isMajority(arr, n, candidate)) {
			System.out.println("Element " + candidate + " occurs more than " + n / 2 + " times");
		} else {
			System.out.println("No element occurs more than " + n / 2 + " times");
		}
	}
}
