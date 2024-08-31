#// Time Complexity : O(N) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No.

class Solution:
    def canJump(self, nums):
        goal = len(nums) - 1
        for i in range(len(nums)-2,-1,-1):
            if nums[i] + i >= goal:
                goal = i
        if goal == 0:
            return True
        else:
            return False
        

                
        # memo = [-1] * len(nums)
    
        # def dfs(nums, idx):
        #     nonlocal memo
        #     # base
        #     if memo[idx] != -1:
        #         return memo[idx]

        #     if idx >= len(nums) - 1:
        #         memo[idx] = True
        #         return memo[idx]
        #     # logic
        #     for j in range(1, nums[idx] + 1):
        #         new_idx = idx + j
        #         if dfs(nums, new_idx):
        #             memo[idx] = True
        #             return memo[idx]
        #     memo[idx] = False
        #     return memo[idx]
        
        # return dfs(nums, 0)

# Approach:
# The problem can be solved using a greedy approach. We start from the end of the array and try
# to find the maximum index that we can reach. If we can reach the maximum index, we move
# to the previous index. We repeat this process until we reach the start of the array. If we
# can reach the start of the array, we return True; otherwise, we return False.
