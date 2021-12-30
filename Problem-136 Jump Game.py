# 55. Jump Game
# https://leetcode.com/problems/jump-game/

# Logic: We create a DP array. We iterate over the input, and for 
# the value of the item from input, we mark the next values as True.
#  After the iteration is complete, ther last index in the dp array 
# will be our answer. The defination of each cell is, Can this cell 
# be reached starting from the start.

# Time Complexity: O(n^2)
# Space Complexity: O(n)

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        dp = [False for i in range(n)]
        dp[0] = True
        
        i = 0
        while i < n and dp[i] == True and dp[n-1] == False:
            for j in range(1,nums[i] + 1):
                if i + j < n:
                    dp[i + j] = True
            i += 1
        return dp[n-1]