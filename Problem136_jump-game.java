// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean canJump(int[] nums) {
        // base
        if(nums == null || nums.length == 0)
            return true;
        if(nums.length < 2)
            return true;
        int n = nums.length;
        int lastPos = n - 1;
        for(int i = n - 2; i >= 0; i--) {
            if(i + nums[i] >= lastPos)
                lastPos = i;
            
        }
        return lastPos == 0;
    }
}