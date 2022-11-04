class Solution:
    def jump(self, nums: List[int]) -> int:
        if nums is None or len(nums) < 2:
            return 0

        dp = [float("inf") for i in range(len(nums))]
        dp[0] = 0

        for i in range(len(nums)):
            for j in range(i):
                if nums[j] + j >= i:
                    dp[i] = min(dp[i], 1 + dp[j])
        return dp[-1]

# DP
# Time Complexity: O(n^2)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : No, Time Limit Exceeded
# Any problem you faced while coding this : No
