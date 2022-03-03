# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums[0] >= len(nums) - 1:
            return True

        idx = len(nums) - 2
        dest = len(nums) - 1

        while idx >= 0:
            if nums[idx] >= dest-idx:
                dest = idx

                if dest == 0:
                    return True

            idx = idx - 1
        return False
