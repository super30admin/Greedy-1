// Time Complexity : O(n) where n is the length of the array nums
// Space Complexity : O(1) where n is the length of the array nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class jumpGame1 {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int lastPos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }    
        }
        return lastPos == 0;
    }
}