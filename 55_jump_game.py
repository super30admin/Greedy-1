from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        """
            https://leetcode.com/problems/jump-game/
            Time Complexity - O(n)
            Space Complexity - O(1)
        """
        dest = len(nums) - 1
        for i in reversed(range(len(nums) - 1)):
            if nums[i] + i >= dest:
                dest = i
        return dest == 0
