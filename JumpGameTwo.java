/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
public class JumpGameTwo
{
    public int jump(int[] nums)
    {
        int length = nums.length;

        int dp[] = new int[length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i =1; i < length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(j + nums[j] >= i)
                {
                    int current = dp[j] + 1;
                    dp[i] = Math.min(dp[i], current);
                }

            }
        }

        return dp[length-1];

    }
}
