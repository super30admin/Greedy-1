# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Use a greedy approach to jump to farthest reachable index.
# 2. Keep track of end of current jump range and increment jumps when moving past it.
# 3. Return total jumps needed to reach the last index.

from typing import List

class Solution:
    def jump(self, nums: List[int]) -> int:
        jumps = 0
        curr_end = 0
        farthest = 0
        
        for i in range(len(nums) - 1):
            farthest = max(farthest, i + nums[i])
            if i == curr_end:
                jumps += 1
                curr_end = farthest
        
        return jumps