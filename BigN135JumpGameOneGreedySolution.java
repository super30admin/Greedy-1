//Time complexity is O(N)
//Space complexity is O(N)
//This solution is submitted on leetcode

public class BigN135JumpGameOneGreedySolution {
	class Solution {
		public boolean canJump(int[] nums) {
			// edge case
			if (nums == null || nums.length < 2)
				return true;
			int n = nums.length;
			int destination = n - 1;
			for (int i = n - 2; i >= 0; i--) {
				if (destination <= i + nums[i]) {
					destination = i;
				}
			}
			return destination == 0;
		}
	}
}