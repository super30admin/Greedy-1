// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int jump(int[] nums) {
        // using BFS -> expand range
        // Level == Jumps
        int left = 0, right = 0, level = 0;

        while (right < nums.length - 1) {
            int maxJump = 0;
            // Move from left to right window and find the max range
            for (int i = left; i <= right; i++) {
                maxJump = Math.max(maxJump, i + nums[i]);
            }

            // update left and right
            left = right + 1;
            right = maxJump;
            level++;
        }

        return level;
    }
}