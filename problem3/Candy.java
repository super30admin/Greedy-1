// Time Complexity : O(n), n -> Length of given array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem3;

import java.util.Arrays;

public class Candy {
	/********************* TWO PASS *********************/
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}

		int n = ratings.length;
		int[] candy = new int[n];

		Arrays.fill(candy, 1);

		// Left Pass
		for (int i = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candy[i] = candy[i - 1] + 1;
			}
		}

		// Right Pass
		int sum = candy[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candy[i] = Math.max(candy[i], candy[i + 1] + 1);
			}
			sum += candy[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		Candy obj = new Candy();
		int[] ratings = { 1, 2, 2 };

		System.out.println("Maximum number of candies given: " + obj.candy(ratings));
	}

}
