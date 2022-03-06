"""
Given an array of non-negative integers nums, 
you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length 
at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.
"""

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def jump(self, nums: List[int]) -> int:
        
        if len(nums) < 2:
            return 0
        
        jumps = 1
        currInt = nums[0]
        nextInt = nums[0]
        
        for i in range(1, len(nums)):
            nextInt = max(nextInt, nums[i] + i)
            if currInt >= len(nums) - 1:
                return jumps
            if currInt == i:
                jumps += 1
                currInt = nextInt
                
                
        