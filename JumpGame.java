//Time Complexity : O(N)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * start from last index. from there check current index + current value could
 * cross last index. if so update last position to reach to current index. reeat
 * till 0th index and at last check if the last position is updated to 0th
 * index.
 *
 */
class Solution {
	public boolean canJump(int[] nums) {
		// int n = nums.length;
		// boolean[] dp = new boolean[n];
		// dp[n-1] = true;
		// for(int i=n-1;i>=0;i--) {
		// int num = nums[i];
		// for(int j=i+1;j<=Math.min(n-1, i+num);j++) {
		// if(dp[j] == true) {
		// dp[i] = true;
		// break;
		// }
		// }
		// }
		// return dp[0];

		int lastPos = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= lastPos)
				lastPos = i;
		}
		return lastPos == 0;
	}
}
