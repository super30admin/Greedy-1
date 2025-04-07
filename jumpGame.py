"""
Start from 0th index (refer notes)
TC - O(n)
SC - O(1)
"""
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums is None or len(nums) == 0: return True

        n = len(nums)
        if n < 2: return True

        moves = nums[0]

        for i in range(n):
            moves = moves - 1
            if moves < 0: return False
            if moves >= n-1: return True
            moves = max(moves, nums[i])
        return True
