// Top down DP
// Time - O(N^2)
// Space - O(N)


class Solution {
    public int jump(int[] nums) {
        
        int[] dp = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            dp[i] = -1;
        }
        
        return helper(0, nums, dp);
    }
    
    private int helper(int i, int[] nums, int[] dp){
        if(i >= nums.length - 1){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int min = nums.length; // because length of the array can be the max no. of steps
        for(int j = 1; j <= nums[i]; j++){
            int result = helper(i+j, nums, dp);
            min = Math.min(min, result);
        }
        dp[i] = 1 + min;
        return dp[i];
    }
}