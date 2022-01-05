// Time Complexity : O(N*N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Arrays;

public class JumpGame_II {
	 public int jump(int[] nums) {
	        if(nums.length==1) return 0;
	        int[] dp=new int[nums.length];
	        Arrays.fill(dp,-1);
	        helper(nums,0,dp); 
	        return dp[0];
	    }
	    
	    public int helper(int[] nums, int index,int[] dp){
	        if(index>=nums.length-1){
	            return 0;
	        }
	        if(dp[index]!=-1){
	            return dp[index];
	        }
	        int min=Integer.MAX_VALUE-1;
	        for(int i=1;i<=nums[index];i++){
	            min=Math.min(min,1+helper(nums,i+index,dp));
	        }
	        
	        dp[index]=min;
	        return dp[index];
	    }
}
