
/*//DFS - Approach
 * The Time complexity of the algorithm is O(2^n) where n is no of elements.
 * The Space complexity of the algorithm is O(1).
 */

/*//Iterative 
 * The Time complexity of the algorithm is O(n) where n is no of elements.
 * The Space complexity of the algorithm is O(1).
 */

public class JumpGameII {

	public int jump(int[] nums) {

		if (nums == null || nums.length < 2)
			return 0;

		int nextInt = nums[0];
		int currInt = nums[0];
		int n = nums.length - 1;
		int jump = 1;

		for (int i = 1; i <= n; i++) {

			nextInt = Math.max(nextInt, nums[i] + i);

			if (i < n && currInt == i) {
				currInt = nextInt;
				jump++;

			}

		}

		return jump;
	}

	// DFS
//	int min;
//
//	public int jump(int[] nums) {
//
//		min = Integer.MAX_VALUE;
//		if (nums.length == 0 || nums.length == 1)
//			return 0;
//
//		dfs(nums, 0, 0);
//
//		return min;
//
//	}
//
//	private void dfs(int[] nums, int index, int jump) {
//
//		// base
//		if (nums.length - 1 <= index) {
//
//			min = Math.min(min, jump);
//			return;
//		}
//
//		// logic
//
//		for (int j = 1; j <= nums[index]; j++) {
//
//			dfs(nums, j + index, jump + 1);
//		}
//
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
