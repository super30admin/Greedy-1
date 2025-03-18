import java.util.Arrays;

/**
 * Time Complexity: O(N) - Greedy
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Greedy Approach - 
 * Converted the recursion tree to range.
 * For any given number in nums, find the farthest it can go, everytime the farthest is found found in the range, increment jumps.
 * The range is found based on the starting index and farthest index possible from numbers in a range.abstract 
 * 
 * DP Approach -
 * Look for all possible jumps to index recursively and, memoize. The minimum jump gives the count of jumps.
 */

public class JumpGame2 {
    // ------------------- DP approach, TC: O(n^2) and SC: O(n) -----------------
    int[] dp;

    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return recurse(0, nums);
    }

    private int recurse(int index, int[] nums) {
        if (index >= nums.length - 1) return 0; // No jumps needed at last index
        
        if (dp[index] != -1) return dp[index];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            int jumps = recurse(index + i, nums);
            if (jumps != Integer.MAX_VALUE) {
                min = Math.min(min, jumps + 1);
            }
        }
        return dp[index] = min;
    }

    // --------------- Greedy Approach --------------------
    public int jump2(int[] nums) {
        int left = 0;
        int right = 0;
        int jumps = 0;

        int n = nums.length - 1;

        while (right < n) {
            int farthest = 0;
            for (int i = left; i <= right; i++) {
                int num = nums[i];
                farthest = Math.max(farthest, num + i);
            }

            left = right + 1;
            right = farthest;
            jumps++;
        }

        return jumps;
    }
    
    public static void main(String[] args) {
        // Your code here
    }
}