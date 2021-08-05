// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 *1. start from end of the array and last index as target.
 *2. move to the left and and try to reach target. 
 *3. if target reached take that index as target for next elements in the loop.
 *4. if you reach target as 0 or less it is feasible. 
 */
public class JumpGame {
	public boolean canJump(int[] nums) {
		int n = nums.length - 1;
		int target = n;
		for (int i = n - 1; i >= 0; i--) {
			if (i + nums[i] >= target) {
				target = i;
			}
		}

		return target <= 0;
	}
}
