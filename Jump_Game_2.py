"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""

class Solution:
    def jump(self, nums: List[int]) -> int:
        max_dest = float("-inf")
        pos = 0
        jump = 0
        
        for i in range(len(nums)-1):
            # Tells max_destination I can go
            max_dest = max(max_dest, i + nums[i])
            
            # gives min Jump so increment my jump
            if pos == i:
                pos = max_dest
                jump += 1
        return jump
