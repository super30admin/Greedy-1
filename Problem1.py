"""
Implemented using a greedy approach. Start from the end and move backward, updating the target index if the current index can reach or go beyond it. If we can eventually move the target to index 0, then we can reach the end from the start.  
Time Complexity: O(n)
Space Complexity: O(1)
"""
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        target = len(nums) - 1
        for i in range(len(nums) - 2, -1, -1):
            if i + nums[i] >= target:
                target = i
        return target == 0 