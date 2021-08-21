# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def canJump(self, nums):
        #
        n = len(nums) - 1

        for i in range(len(nums) - 1, -1, -1):
            if i + nums[i] >= n:
                n = i
        if n == 0:
            return True
        return False
