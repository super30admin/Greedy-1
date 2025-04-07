"""
Optimized approach using 3 variables - jumps, currinterval, nextinterval
TC - O(n)
SC - O(1)
"""
class Solution:
    def jump(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0: return 0

        n = len(nums)
        if n < 2: return 0

        jumps = 1
        currinterval = nums[0]
        nextinterval = nums[0]

        for i in range(1, n):
            nextinterval = max(nextinterval, nums[i] + i)
            # move to next interval
            if i < n - 1 and i == currinterval:
                jumps += 1
                currinterval = nextinterval
            # additional optimization - refer notes
            if currinterval > n - 1: return jumps
        return jumps