# 45. Jump Game II
# https://leetcode.com/problems/jump-game-ii/

# Logic: We create a DP array. We iterate over the input, and for 
# the value of the item from input, we set the next values as the min steps to reach it.
# After the iteration is complete, ther last index in the dp array 
# will be our answer. The defination of each cell is, min steps 
# from the start to reach this cell.

# Time Complexity: O(n^2)
# Space Complexity: O(n)

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [inf for i in range(n)]
        dp[0] = 0
        
        for i in range(n):
            for j in range(1, nums[i] + 1):
                if i + j < n:
                    dp[i+j] = min(dp[i+j], dp[i]+1)
        
        return dp[n-1]