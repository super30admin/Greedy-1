from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return 0
        jumps = 1
        cur_end = nums[0]
        cur_farthest = nums[0]
        for i in range(1, n):
            if i > cur_end:
                jumps += 1
                cur_end = cur_farthest
            cur_farthest = max(cur_farthest, i+nums[i])
        return jumps




        