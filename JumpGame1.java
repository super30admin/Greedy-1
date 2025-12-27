// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We follow greedy approach and check if we are able to reach or cross the end index of the array but we do backward parsing. We set the target to end of
// the array's index and start looping from n-2 index. If we can reach the target from current position we update the target to the
// current position and continue. If the target reaches index 0, that means target can be reached by jumps and we return true.

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int target = n - 1; //set target to end of nums array index
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= target) { //implies we can reach the target
                target = i; //move the target to i
            }
        }

        if (target == 0) { //we reached the start of array
            return true;
        }
        return false;
    }
}