// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

//starting from end, we'll check if we can reach destination from that index, 
//if we can, then we have a new destination. at the end if destination becomes starting point, that means
//we can reach destination
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int dest = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= dest) {
                dest = i;
            }

        }
        if (dest == 0) {
            return true;
        }
        return false;
    }
}