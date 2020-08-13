//TC - O(3N)
//SC - O(1)
class Solution1 {
	public int jump(int[] nums) {
		if (nums == null || nums.length < 2)
			return 0;
		int n = nums.length - 1;
		int nextInt = nums[0];
		int currInt = nums[0];
		int jump = 1;
		for (int i = 1; i < nums.length; i++) {
			nextInt = Math.max(nextInt, nums[i] + i);
			if (i < n && i == currInt) {
				currInt = nextInt;
				jump++;
			}
		}
		return jump;
	}
}