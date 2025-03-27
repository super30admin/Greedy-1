// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int n = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (maxReach >= i)
                maxReach = Math.max(i + nums[i], maxReach);
        }

        return maxReach >= n;
    }
}