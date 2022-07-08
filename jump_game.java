// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes


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