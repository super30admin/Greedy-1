// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean canJump(int[] nums) {
        boolean[] canJump = new boolean[nums.length];
        
        int target = nums.length-1;
        canJump[nums.length-1] = true;
        for(int i = nums.length-2;i>=0;i--) {
            if(i+nums[i]>=target) {
                canJump[i] = true;
                target = i;
            }
        }
        
        return canJump[0];
    }
}
