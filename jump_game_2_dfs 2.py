# Time Complexity : O(N^M) where N elements in the array and M is max (jump capacity/strength) number in the array
# Space Complexity : O(N) where N is number of elements in the array.
# Did this code successfully run on Leetcode : No (Time Limit Exceeded)
# Any problem you faced while coding this : No

#DFS Solution
class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) <= 1: return 0
        minJumps = 0
        return self.dfs(nums, 0, 0)
        
    def dfs(self, nums, index, jumps):
        #base
        if index >= len(nums) - 1:
            return jumps
        
        #logic
        minJumps = float('inf')
        for i in range(nums[index], 0, -1):
            nextIndex = index + i 
            rjumps = self.dfs(nums, nextIndex, jumps+1)
            
            minJumps = min(minJumps, rjumps)
                    
        return minJumps