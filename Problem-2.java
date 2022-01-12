// Time Complexity : O(n^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=0;i<dp.length;i++) {
            dp[i] = -1;
        }
        
        return helper(0,nums,dp);
    }
    
    private int helper(int startIndex, int[] nums, int[] dp) {
        //base
        if(startIndex >= nums.length-1) {
            //dp[startIndex] = 0;
            return 0;
            
        }
        
        if(dp[startIndex] != -1) {
            return dp[startIndex];
        }
        
        //logic
        int min = Integer.MAX_VALUE-1;
        
        for(int i=0;i<nums[startIndex];i++) {
            int temp = helper(startIndex+i+1,nums,dp);
            
            if(temp<min) {
                min = temp;
            }
        }
        dp[startIndex] = 1 + min;
        return dp[startIndex];
    }
}