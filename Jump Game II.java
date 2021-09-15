class Solution {
    public int jump(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = 0;
        Arrays.fill(dp,10001);

        for(int i=1 ; i<nums.length ; i++)
        {
          for(int j=0 ; j<i ; j++)
          {
              if(j+nums[j]>=i)
              {
                  dp[i] = Math.min(j+1,dp[j]+1);
                  break;
              }

          }
        }

        return dp[dp.length-1] == 10001 ? 0 : dp[dp.length-1];

    }
}
