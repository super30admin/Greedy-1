// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/*
 * 1. can be solved using BFS by generating all possible nodes.
 * 2. when reach the end index that level will be the min jumps.
 */
public class JumpGameII {
	public int jump(int[] nums) {
		if (nums.length == 1)
			return 0;
		
		//initialize first jump
		int jumps = 1;
		int curInt = nums[0];
		int nextInt = nums[0];

		
		for (int i = 1; i < nums.length; i++) {
			nextInt = Math.max(nextInt, nums[i] + i);
			if (i <= nums.length - 2 && i == curInt) {
				jumps++;
				curInt = nextInt;
			}
		}

		return jumps;
	}
}
