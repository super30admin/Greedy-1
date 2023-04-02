import java.util.Arrays;
//Time Complexity : O(N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Calculate candies that can put from left to right and then from right to
 * left. Then take the max of each index and add it to the sum. return sum.
 *
 */
class Solution {
	public int candy(int[] ratings) {
		int n = ratings.length;
		int[] left = new int[n];
		int[] right = new int[n];
		Arrays.fill(left, 1);
		Arrays.fill(right, 1);
		for (int i = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1])
				left[i] = left[i - 1] + 1;
		}

		for (int i = n - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				right[i] = right[i + 1] + 1;
		}
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += Math.max(left[i], right[i]);
		return sum;
	}
}
