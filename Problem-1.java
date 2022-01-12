// Time Complexity : O(n^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=0;i<dp.length;i++) {
            dp[i] = -1;
        }
        
        helper(0,nums,dp);
        
        return dp[0] == 1;
    }
    
    private boolean helper(int startIndex, int[] nums, int[] dp) {
        //base
        if(startIndex >= nums.length-1) {
            dp[startIndex] = 1;
            return true;
            
        }
        
        if(dp[startIndex] == 1) {
            return true;
        }
        if(dp[startIndex+1] == 0) {
            return false;
        }
        
        //logic
        for(int i=0;i<nums[startIndex];i++) {
            
            
            if(helper(startIndex+i+1,nums,dp)) {
                dp[startIndex] = 1;
                return true;
            }
        }
        dp[startIndex] = 0;
        return false;
    }
}