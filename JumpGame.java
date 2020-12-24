public class JumpGame {
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;

		int destination = nums.length - 1;
		int n = nums.length - 1;
		for (int i = n; i >= 0; i--) {
			if (i + nums[i] >= destination) {
				destination = i;
			}
		}
		return destination == 0;
	}
}
