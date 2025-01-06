# The jump method calculates the minimum number of jumps needed to reach the last index.

# Use a greedy approach:
# - Maintain a window `[l, r]` representing the range of indices reachable in the current jump.
# - Find the farthest index reachable in the next jump.
# - Update the window and increment the jump count (`res`).

# Continue until the right boundary reaches or exceeds the last index.

# TC: O(n) - Each index is visited once.
# SC: O(1) - Constant space usage.


from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        res = 0
        l = r = 0

        while r < len(nums) - 1:
            farthest = 0
            for i in range(l, r + 1):
                farthest = max(farthest, i + nums[i])
            l = r + 1
            r = farthest
            res += 1
        return res