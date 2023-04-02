//Time Complexity : O(N)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * take steps as 0. Iterate from 0 to n-1. At each step, calculate max distance
 * it can jump and put it in end. Also maintain a current end variable to track
 * the current end position. When i reaches the current end position, increment
 * steps and update current end to the end which would be the next end that has
 * to be reached.
 *
 */
class Solution {
	public int jump(int[] nums) {
		// int[] dp = new int[nums.length];
		// Arrays.fill(dp, 10000);
		// int n = nums.length;
		// dp[n-1] = 0;
		// for(int i=n-2;i>=0;i--) {
		// int num = nums[i];
		// for(int j=i+1;j<=Math.min(n-1, i+num);j++) {
		// dp[i] = Math.min(dp[i], 1 + dp[j]);
		// }
		// }
		// return dp[0];
		int steps = 0;
		int n = nums.length, curEnd = 0, end = 0;
		for (int i = 0; i < n - 1; i++) {
			end = Math.max(end, i + nums[i]);
			if (i == curEnd) {
				steps++;
				curEnd = end;
			}
		}
		return steps;
	}
}
