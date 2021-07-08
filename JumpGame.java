// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean canJump(int[] nums) {
        
        int destination = nums.length-1;
        
        for (int i=nums.length-2; i>=0; i--)
            destination = i+nums[i]>=destination ? i : destination;
        
        return destination == 0;
    }
}