//Time Complexity : O(n), n -> Length of given array
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
package problem1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGame {
	Set<Integer> visited;

	/********************* BFS *********************/
	// Time Complexity : Exponential
	// Space Complexity : Size of queue
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public boolean canJumpBFS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}

		if (nums.length == 1) {
			return true;
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		visited = new HashSet<Integer>();

		visited.add(0);
		queue.add(0);

		while (!queue.isEmpty()) {
			int index = queue.poll();
			for (int i = 1; i <= nums[index]; i++) {
				int newIndex = index + i;

				if (newIndex == nums.length - 1) {
					return true;
				}

				if (!visited.contains(newIndex)) {
					queue.add(newIndex);
					visited.add(newIndex);
				}
			}
		}
		return false;
	}

	/********************* DFS *********************/
	// Time Complexity : Exponential
	// Space Complexity : Size of queue
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public boolean canJumpDFS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}

		if (nums.length == 1) {
			return true;
		}

		visited = new HashSet<Integer>();

		return dfs(0, nums);
	}

	private boolean dfs(int index, int[] nums) {
		// Base
		if (visited.contains(index)) {
			return false;
		}

		if (index == nums.length - 1) {
			return true;
		}
		// Logic
		visited.add(index);
		for (int i = 1; i <= nums[index]; i++) {
			if (dfs(index + i, nums)) {
				return true;
			}
		}

		return false;
	}

	/********************* GREEDY *********************/
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}

		int dest = nums.length - 1;

		for (int i = nums.length - 2; i >= 0; i--) {
			if (i + nums[i] >= dest) {
				dest = i;
			}
		}

		return dest == 0;
	}

	public static void main(String[] args) {
		JumpGame obj = new JumpGame();
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println("Is it possible to reach the last index? " + (obj.canJump(nums) ? "Yes" : "No"));
	}

}
