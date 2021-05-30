# Time Complexity: O(n)
# Space Complexity: O(1)
# Ran on Leetcode: Yes

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) < 2:
            return True
        n = len(nums)
        dest = n - 1
        for i in range(n-2, -1, -1):
            if i + nums[i] >= dest:
                dest = i
        if dest == 0:
            return True
        return False