# Time Complexity : O(n), n = length of nums
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Track the farthest index reachable as we iterate.
# 2. If current index > farthest reachable, return False.
# 3. If we can reach the last index, return True.

from typing import List

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        farthest = 0
        for i, jump in enumerate(nums):
            if i > farthest:
                return False
            farthest = max(farthest, i + jump)
        return True