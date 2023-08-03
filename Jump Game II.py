# Time Complexity : O(n)
# Space Complexity : O(1)
# The code ran on Leetcode
# At every index, find the next best interval we can reach from the current index. Whenever we move to the next Interval, increase jumps by 1

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 2: return 0
        jumps = 1
        curInt = nums[0]; nextInt = nums[0]
        for i in range(1, n-1):
            nextInt = max(nextInt, i + nums[i])
            if i == curInt:
                curInt = nextInt
                jumps+=1
        return jumps