// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach: Implemented greedy apporach to check just for a value before destination. If it is going to the destination then the destination is changed to current value else i is decremented by 1

class Solution {
    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return true;
        }

        int dest = nums.length - 1;

        for (int i = dest - 1; i >= 0; i--) {
            if (i + nums[i] >= dest) {
                dest = i;
            }
        }

        return dest == 0;

    }
}