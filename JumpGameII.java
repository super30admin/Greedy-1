// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Initialization: Set initial jumps to 1 and set curr and next to the maximum distance from the first index.
//Update Maximum Reach: For each index, update next to the farthest position reachable. If the current index reaches curr, increment the jump count and update curr to next.
//Return Jumps: Return the total number of jumps needed to reach or exceed the last index.

class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int jump = 1, curr = nums[0], next = nums[0];
        for (int i = 0; i < nums.length; i++) {
            next = Math.max(next, nums[i] + i);
            if (i < nums.length - 1 && i == curr) {
                jump++;
                curr = next;
            }
        }
        return jump;
    }
}