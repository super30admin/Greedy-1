// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// Set destination to last index and start iteration from right to left starting from n - 2
// If we are able to reach destination from ith element, we update destination to i
// At the end if destination is 0, return true

class Solution {
    public boolean canJump(int[] nums) {

        if(nums == null || nums.length < 2) {
            return true;
        }

        int destination = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--) {

            if(i + nums[i] >= destination) {
                destination = i;
            }
        }

        if(destination == 0) return true;

        return false;
    }
} 
