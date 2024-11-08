package dp.Algo.DP;
import java.util.Arrays;

public class OptimalBST {
	static int optBstCost(int[] freq, int i, int j) {
		if (i > j)
			return 0;

		if (j == i) // one element in this subarray
			return freq[i];

		int min = Integer.MAX_VALUE;
		for (int r = i; r <= j; r++) {
			min = Math.min(min, optBstCost(freq, i, r - 1) + optBstCost(freq, r + 1, j));
		}
		return min + sum(freq, i, j);
	}

	static int optBstCost(int[] keys, int[] freq) {
		int n = freq.length;
		return optBstCost(freq, 0, n - 1);
	}

	static int optBstCostTD(int[] keys, int[] freq) {
		int n = freq.length;
		int[][] cost = new int[n][n];
		for (int[] row : cost)
			Arrays.fill(row, Integer.MAX_VALUE);

		for (int i = 0; i < n; i++)
			cost[i][i] = freq[i];

		return optBstCostTD(freq, cost, 0, n - 1);
	}

	static int optBstCostTD(int[] freq, int[][] cost, int i, int j) {
		if (i > j)
			return 0;

		if (cost[i][j] != Integer.MAX_VALUE)
			return cost[i][j];

		int s = sum(freq, i, j);
		for (int r = i; r <= j; r++) {
			cost[i][j] = Math.min(cost[i][j],
					optBstCostTD(freq, cost, i, r - 1) + optBstCostTD(freq, cost, r + 1, j) + s);
		}
		return cost[i][j];
	}

	static int sum(int[] freq, int i, int j) {
		int s = 0;
		for (int k = i; k <= j; k++)
			s += freq[k];
		return s;
	}

	static int[] sumInit(int[] freq, int n) {
		int[] sum = new int[n];
		sum[0] = freq[0];
		for (int i = 1; i < n; i++)
			sum[i] = sum[i - 1] + freq[i];
		return sum;
	}

	static int sumRange(int[] sum, int i, int j) {
		if (i == 0)
			return sum[j];
		return sum[j] - sum[i - 1];
	}

	static int optBstCostBU(int[] keys, int[] freq) {
		int n = freq.length;
		int[][] cost = new int[n][n];
		for (int[] row : cost)
			Arrays.fill(row, Integer.MAX_VALUE);

		for (int i = 0; i < n; i++)
			cost[i][i] = freq[i];

		int sm = 0;
		for (int l = 1; l < n; l++) { // l is length of range.
			for (int i = 0, j = i + l; j < n; i++, j++) {
				sm = sum(freq, i, j);
				for (int r = i; r <= j; r++) {
					cost[i][j] = Math.min(cost[i][j],
							sm + ((r - 1 >= i) ? cost[i][r - 1] : 0) + ((r + 1 <= j) ? cost[r + 1][j] : 0));
				}
			}
		}
		return cost[0][n - 1];
	}

	static int optBstCostBU2(int[] keys, int[] freq) {
		int n = freq.length;
		int[][] cost = new int[n][n];
		for (int[] row : cost)
			Arrays.fill(row, Integer.MAX_VALUE);

		int[] sumArr = sumInit(freq, n);
		for (int i = 0; i < n; i++)
			cost[i][i] = freq[i];

		int sm = 0;
		for (int l = 1; l < n; l++) { // l is length of range.
			for (int i = 0, j = i + l; j < n; i++, j++) {
				sm = sumRange(sumArr, i, j);
				for (int r = i; r <= j; r++) {
					cost[i][j] = Math.min(cost[i][j],
							sm + ((r - 1 >= i) ? cost[i][r - 1] : 0) + ((r + 1 <= j) ? cost[r + 1][j] : 0));
				}
			}
		}
		return cost[0][n - 1];
	}

	public static void main(String[] args) {
		int[] keys = { 9, 15, 25 };
		int[] freq = { 30, 10, 40 };
		System.out.println("OBST cost:" + optBstCost(keys, freq));
		System.out.println("OBST cost:" + optBstCostTD(keys, freq));
		System.out.println("OBST cost:" + optBstCostBU(keys, freq));
		System.out.println("OBST cost:" + optBstCostBU2(keys, freq));
	}
}

/*
OBST cost:130
OBST cost:130
OBST cost:130
OBST cost:130
*/