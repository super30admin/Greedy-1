"""
Time Complexity : O(n) 
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def canJump(self, nums):
        if not nums or len(nums) == 0:
            return False
        
        n = len(nums)
        currDest = n - 1
        i = n - 2
        
        while i >= 0:
            if i + nums[i] >= currDest:
                currDest = i    
            i -= 1
            
        if currDest == 0:
            return True
        
        return False