class Solution {
    //tc-exponential
    int[] dp;
    public boolean canJump(int[] nums) {
         dp = new int[nums.length]; // -1 not visited, 2 visited unable to reach destination ,1 visited
        Arrays.fill(dp,-1);
        if(nums.length < 2) return true;
        return dfs(nums,0);
    }
    private boolean dfs(int[]nums, int i)
    {
      //basecase
      if(i >= nums.length-1) return true;
      if( dp[i] == 2) return false;
      //logic
      //int max = nums[i];
      //for(int j=max;j>=1;j--)
      dp[i] = 1;
      for(int j=1;j<=nums[i];j++) //2 to 1
      {
          int newidx = i+j;
          if(dp[newidx] == -1 && dfs(nums,newidx)) return true;
      }
      dp[i] = 2;
      return false;
    }
}