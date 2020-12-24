public class JumpGame2 {
	public int jump(int[] nums) {

		if (nums == null || nums.length < 2)
			return 0;
		int currInt = nums[0];
		int nextInt = nums[0];
		int jump = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			nextInt = Math.max(nextInt, i + nums[i]);
			if (currInt != nums.length - 1 && currInt == i) {
				currInt = nextInt;
				jump++;
			}
		}
		return jump;

	}
}
