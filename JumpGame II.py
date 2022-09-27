# Time Complexity : O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if (n < 2): return 0
        curr = nums[0]
        nexti = nums[0]
        jump = 1

        for i in range(1, len(nums)):
            nexti = max(nexti, i + nums[i])
            if (i != n - 1 and i == curr):
                jump += 1
                curr = nexti
        return jump
