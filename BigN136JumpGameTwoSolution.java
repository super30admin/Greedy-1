//Time complexity is O(N)
//Space complexity is O(1)
//This solution is submitted on leetcode

public class BigN136JumpGameTwoSolution {
	class Solution {
		public int jump(int[] nums) {
			// edge case
			if (nums == null || nums.length < 2)
				return 0;
			int n = nums.length;
			int jump = 1;
			int currInterval = nums[0];
			int nextInterval = nums[0];
			for (int i = 0; i < n; i++) {
				nextInterval = Math.max(nextInterval, i + nums[i]);
				if (i < n - 1 && i == currInterval) {
					currInterval = nextInterval;
					jump++;
				}
			}
			return jump;
		}
	}
}