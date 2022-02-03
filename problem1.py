# Time Complexity : O(n)
# Space Complexity:o(1)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def __init__(self):
        self.hset = set()

    def canJump(self, nums: List[int]) -> bool:
        dest = len(nums) - 1

        for i in range(dest - 1, -1, -1):
            if nums[i] + i >= dest:
                dest = i

        return dest == 0


