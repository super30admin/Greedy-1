# Time Complexity : O(n)
# Space Complexity : O(1)
# The code ran on Leetcode
# Initialize target variable to n - 1. Traverse the array in reverse order, move the target to the first index from where target can be reached. At the end, if target == 0, return True
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        target = n - 1

        for i in range(n-2, -1, -1):
            if i + nums[i] >= target:
                target = i
        return target == 0