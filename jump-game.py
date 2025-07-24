# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # Track the maximum position we can reach
        max_reach = 0
        
        # Iterate through each position
        for i in range(len(nums)):
            # If current position is beyond what we can reach, return False
            if i > max_reach:
                return False
            
            # Update the maximum reachable position
            max_reach = max(max_reach, i + nums[i])
            
            # If we can already reach the last index, return True
            if max_reach >= len(nums) - 1:
                return True
        
        return True
        