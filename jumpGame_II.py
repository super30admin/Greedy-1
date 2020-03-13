"""
Time Complexity : O(n) 
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def jump(self, nums: List[int]) -> int:
        if not nums or len(nums) < 2:
            return 0
        
        n = len(nums)
        currInt = nums[0]
        nextInt = nums[0]
        jumps = 1
        
        for i in range(n):
            nextInt = max(nextInt, nums[i]+i)
            if i < n-1 and i == currInt:
                currInt = nextInt
                jumps += 1
                             
        return jumps
                