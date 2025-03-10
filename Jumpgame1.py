# TC : O(n)
# SC : O(1)
from typing import List

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        destination = n - 1  # Last index
        
        # Traverse from second-last element to first element
        for i in range(n - 2, -1, -1):
            if i + nums[i] >= destination:
                destination = i  # Move the destination backwards

        return destination == 0  # If we can reach index 0, return True


