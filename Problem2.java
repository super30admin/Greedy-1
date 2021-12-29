// Time - O(n2)
// Space - O(n)
// 45 Jump game 2 DP solution
class Solution {
    public int jump(int[] nums) {
        
        int[] dp = new int[nums.length];
        
        for(int i = 0; i < nums.length; i ++){
            dp[i] = -1;
        }
        
        return helper(nums, 0, dp);
    }
    
    public int helper(int[] nums, int i, int[] dp){
        
        if(i >= nums.length - 1){
            return 0;
        }
        
        int minSteps = Integer.MAX_VALUE - 1;
        
        if(dp[i] != -1){
            return dp[i];
        }
        
        for(int j = 1 ; j <= nums[i]; j++){ 
            
            int result = helper(nums, i + j, dp);
            minSteps = Math.min(minSteps, result);
        }
        
        dp[i] = 1 + minSteps;
        
        return dp[i];
    }
}