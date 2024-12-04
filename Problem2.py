# Problem 2: Jump Game II
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1: return 0
        jumps = 1
        currInt = nums[0]
        maxInt = nums[0]

        for i in range(n):
            if i == n-1: continue
            maxInt = max(maxInt,nums[i]+i)

            if i == currInt:
                jumps += 1
                currInt = maxInt

            if currInt >= n-1:
                return jumps

        return 934
        