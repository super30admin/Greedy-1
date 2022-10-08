# Optimized DFS
# Time complexity : O(n^k)
# Space complexity : O(n^k)
# Leetcode : Time limit exceeded

from collections import deque
class Solution:
  
    # make a global dp array
    dp = []
    # -1 - not visited
    # 1 - visited
    # 2 - visted and not reachable to last index
    def canJump(self, nums: List[int]) -> bool:
        # if the length of the list is less than 2, return True
        if len(nums) < 2:
            return True
        
        # fill the dp array with all -1
        n = len(nums)
        self.dp = [-1] * n
        
        # call the dfs function with the array and starting index as 0
        return self.dfs(nums, 0)
    
    def dfs(self, nums, i):
        # base case
        # if we go over the last index or equal then return True
        if i >= len(nums) - 1:
            return True
          
        # mark the index as visited by marking the index in dp array as 1
        self.dp[i] = 1
        
        # traverse over the array from the end
        for j in range(nums[i],0,-1):
          
            # find the new index
            idx =  i + j
            
            # if we have reached the end, then return True here itself
            if idx >= len(nums) - 1:
                return True
              
            # if we find a index from where the last index is not reachable then we do not go ahead, otherwise recursively call the dfs on new index
            if self.dp[idx] != 2  and self.dfs(nums, idx):
                return True
        
        # if we reach here, it means there is no way of reaching to last index from this position
        self.dp[i] = 2
        
        # return False as we could not find any index position
        return False
