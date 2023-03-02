# Time Complexity: O(n), Where n is number of elements in nums List
# Space Complexity : O(1)

class Solution:
    def jump(self, nums: List[int]) -> int:
        dp = [0 for i in range(len(nums))]
        for i in range(len(dp)-2, -1, -1):
            if nums[i] == 0:
                dp[i] = float("inf")
            elif i + nums[i] >= len(nums)-1:
                dp[i] = 1
            else:
                dp[i] = 1 + min(dp[i+1:i+nums[i]+1])
        return (dp[0])
