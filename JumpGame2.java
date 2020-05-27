// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : TLE , all cases passed
// Any problem you faced while coding this : No

public class JumpGame2 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = 0;

        for(int i = 1; i < dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(j + nums[j] >= i){
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }

        return dp[dp.length - 1];
    }
}
