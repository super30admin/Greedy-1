"""
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums or len(nums)==1: return True

        destination = len(nums) - 1        
        
        for i in range(len(nums)-1, -1, -1):
            if i + nums[i] >= destination:
                destination = i     # Set dest. to 'i' if, from 'i', we can reach prev. dest.
        
        if destination == 0:
            return True
        else:
            return False