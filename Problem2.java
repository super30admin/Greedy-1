// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach: Used scope and farthest. Scope is where the i can go and jump is incremented after that and farthest is used to check if it reaches the last index

class Solution {
    public int jump(int[] nums) {

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int scope = 0;
        int farthest = 0;
        int jump = 0;

        for (int i = 0; i < nums.length; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1)
                return jump + 1;

            if (i == scope) {
                scope = farthest;
                jump++;
            }

        }

        return jump;
    }
}