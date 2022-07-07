# Time Complexity : O(N^M) where N elements in the array and M is max (jump capacity/strength) number in the array
# Space Complexity : O(N) where N is number of elements in the array.
# Did this code successfully run on Leetcode : No (Time Limit Exceeded)
# Any problem you faced while coding this : No

#DFS Solution
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) == 1: return True
        hashset = set()
        
        return self.dfs(nums, 0, hashset)
        
    def dfs(self, nums, index, hashset):
        #base
        if index >= len(nums) - 1:
            return True
        
        if index in hashset:
            return False
        
        #logic
        hashset.add(index)
        for i in range(1, nums[index] + 1):
            nextIndex = index + i 
            if self.dfs(nums, nextIndex, hashset) : return True
                    
        return False