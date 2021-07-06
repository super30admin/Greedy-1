# Time Complexity : O(n ^ k) [n = length of input list, k = largest number in the list]
# Space Complexity : O(k) [Stack space, k = largest number in the list]
# Did this code successfully run on Leetcode : TLE
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# 1. Follow all the possible path starting from the first index
# 2. If the index hits the last index during the recusive process, the solution is reached
class Solution:
    def canJump_Recursive(self, nums: List[int]) -> bool:
        def dfs(nums, i):
            ## base
            if i == len(nums)-1:
                return True
            ## body
            for index in range(1,nums[i]+1):
                if dfs(nums, i + index):
                    return True
            return False
                
        return dfs(nums, 0)


    def canJump_Recursive_Memoization(self, nums: List[int]) -> bool:
        memo = [[ None for _ in range(len(nums))] for _ in range(len(nums))]
        def dfs(nums, i):
            ## base
            if i == len(nums)-1:
                return True
            ## body
            for index in range(1,nums[i]+1):

                # memoization
                if memo[i][index] is not None and memo[i][index] == True:
                    return True
                else:
                    memo[i][index] = dfs(nums, i + index)
                    if memo[i][index] == True:
                        return memo[i][index]
            return False
                
        return dfs(nums, 0)