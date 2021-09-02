//Time Complexity : O(n), n -> Length of given array
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
package problem2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGame2 {
	int jumps;

	/********************* BFS *********************/
	// Time Complexity : Exponential
	// Space Complexity : Size of queue
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int jumpBFS(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();

		visited.add(0);
		queue.add(0);
		jumps = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int index = queue.poll();
				for (int j = 1; j <= nums[index]; j++) {
					int newIndex = index + j;

					if (newIndex == nums.length - 1) {
						return jumps + 1;
					}

					if (!visited.contains(newIndex)) {
						queue.add(newIndex);
						visited.add(newIndex);
					}
				}
			}
			jumps++;
		}
		return jumps;
	}

	/********************* DFS *********************/
	// Time Complexity : Exponential
	// Space Complexity : Size of queue
	// Did this code successfully run on Leetcode : TimeLimit Exceeded
	// Any problem you faced while coding this : No
	int minJumps;

	public int jumpDFS(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		minJumps = Integer.MAX_VALUE;

		dfs(nums, 0, 0);
		return minJumps;
	}

	private void dfs(int[] nums, int index, int jumps) {
		// Base
		if (index >= nums.length - 1) {
			minJumps = Math.min(minJumps, jumps);
			return;
		}
		// Logic
		for (int i = 1; i <= nums[index]; i++) {
			int newIndex = index + i;
			dfs(nums, newIndex, jumps + 1);
		}
	}

	/********************* GREEDY *********************/
	//Time Complexity : O(n), n -> Length of given array
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int jump(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		int jumps = 1;
		int curr = nums[0];
		int next = nums[0];

		for (int i = 1; i < nums.length; i++) {
			next = Math.max(next, nums[i] + i);
			if (i < nums.length - 1 && i == curr) {
				jumps++;
				curr = next;
			}
		}

		return jumps;
	}

	public static void main(String[] args) {
		JumpGame2 obj = new JumpGame2();
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println("Minimum number of jumps to reach last index: " + obj.jump(nums));
	}

}
