// Time Complexity : O(n) --> where n is the length of input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (55): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean canJump(int[] nums) {
        // edge case
        if (nums == null || nums.length < 2) return true;
        
        int n = nums.length;
        int destination = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= destination) destination = i;
        }
        if (destination == 0) return true;
        else return false;
    }
}