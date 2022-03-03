# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:

        if len(nums) == 1:
            return 0

        jumps = 0  # count of no. of jumps
        jump_end = 0  # range that we can jump to
        farthest = 0  # farthest that we can reach

        for i in range(len(nums) - 1):
            # we continuously find how far we can reach in the current jump
            farthest = max(farthest, i + nums[i])

            # if we have come to the end of the current jump,
            # we need to make another jump
            if i == jump_end:
                jumps = jumps + 1
                jump_end = farthest

        return jumps
