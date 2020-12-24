public class JumpGame {
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;

		int destination = nums.length - 1;
		int n = nums.length - 1;
		for (int i = n-1; i >= 0; i--) {
			if (i + nums[i] >= destination) {
				destination = i;
			}
		}
		return destination == 0;
	}

	public static void main(String[] args) {
		JumpGame g = new JumpGame();

		g.canJump(new int[] { 2, 3, 1, 1, 4 });
	}
}
