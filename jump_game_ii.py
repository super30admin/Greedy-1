"""
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""

class Solution:
    def jump(self, nums: List[int]) -> int:
        if not nums or len(nums) == 1: return 0
        n = len(nums)
        
        jumps = 0
        curr_interval = 0
        next_interval = 0
        
        for i in range(n-1):
            next_interval = max(next_interval, i + nums[i])
            
            if i == curr_interval:
                jumps += 1
                curr_interval = next_interval
                
        return jumps