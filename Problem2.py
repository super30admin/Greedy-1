"""
Implemented using a greedy approach to minimize jumps. We track the current interval's end (`currInt`) and the farthest reachable index (`maxInt`). Whenever we reach the end of the current interval, we increase the jump count and update the interval.
Time Complexity: O(n)
Space Complexity: O(1)
"""
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return 0
        maxInt = nums[0]
        currInt = nums[0]
        jumps = 1
        for i in range(1, n):
            maxInt = max(maxInt, i + nums[i])
            if i != n - 1 and i == currInt:
                jumps += 1
                currInt = maxInt
        return jumps    