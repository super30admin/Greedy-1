// Time Complexity : O(N) //2N
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 *1. pass1: initialize all to have 1 candy.
 *2.		if previous student rating is less increase by 1 candy to current student
 *3. pass2: start from the end of the array.
 *4.		if previous student rating is less find max candies of current candies, previous student candies+1.
 *5. sum all counts and return.
 */

public class Candy {
	public int candy(int[] ratings) {
		int[] candies = new int[ratings.length];
		candies[0] = 1;

		// pass one start to end
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			} else {
				candies[i] = 1;
			}
		}

		// pass two end to start
		int sum = candies[ratings.length - 1];
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
			}
			sum += candies[i];
		}

		return sum;
	}
}
