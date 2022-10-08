# DFS
# Time complexity : O(n^k)
# Space complexity : O(n^k)
# Leetcode : Time limit exceeded

from collections import deque
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # if the list has length less than 2, return True
        if len(nums) < 2:
            return True
        
        # find the length of the list and call the dfs function with the starting index as 0
        n = len(nums)
        return self.dfs(nums, 0)
    
    def dfs(self, nums, i):
        # if we have reached or go over the lenghth of list or the last index, then return True
        if i >= len(nums) - 1:
            return True
        
        # start the traversal from the last element till 0 and recursively call the dfs function on the nums array and the new index
        for j in range(nums[i],0,-1):
            idx =  i + j
            if self.dfs(nums, idx):
                return True
        
        return False
