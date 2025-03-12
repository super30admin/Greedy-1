class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # T: O(n), S: O(1)
        max_reach = 0  # Track farthest reachable index
        for i, jump in enumerate(nums):
            if i > max_reach:  # If we are stuck
                return False
            max_reach = max(max_reach, i + jump)
            if max_reach >= len(nums) - 1:  # Early exit if last index is reachable
                return True
        return False
