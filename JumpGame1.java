// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        // consider lastIndex as Good Index
        int lastIndex = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            // Let check if we can reach to the Good Index -> If Yes we will shift the Good Index
            // to the position from where we jumped
            if (nums[i] + i >= lastIndex) {
                lastIndex = i;
            }
        }

        return lastIndex == 0 ;
    }
}