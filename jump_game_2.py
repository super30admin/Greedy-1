# Time Complexity: O(n)
# Space Complexity: O(1)
# Ran on Leetcode: Yes

class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) < 2 :
            return 0
        res = 1
        currVal = nums[0]
        nextVal = nums[0]
        n = len(nums)
        for i in range(1, n):
            nextVal = max(nextVal, i + nums[i])
            if i == currVal and i < n - 1:
                currVal = nextVal
                res += 1
        return res