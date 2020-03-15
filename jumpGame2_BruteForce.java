// Time Complexity : O(n^2) where n is the length of the array nums
// Space Complexity : O(n) where n is the length of the array nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class jumpGame2_BruteForce {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            // dp[i] = min of previous dp values from which that cell can be reached + 1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i)
                    min = Math.min(min, dp[j]);    
            }
            dp[i] = min + 1;
        }
        return dp[nums.length - 1];
    }
}