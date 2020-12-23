"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
THIS is similar to the jump game 1. We will start iterating from the very beginning. The only difference is 
that we would be maintaining a current onterval and a next interval here. The next interval defines the
maximum value till where we can jump from any value in the current interval. The current interval was next interval
previously.
"""


class Solution:
    def jump(self, nums: List[int]) -> int:
        if not nums or len(nums) < 2:
            return 0
        jumps = 1
        curr = nums[0]
        nextInt = nums[0]
        l = len(nums)
        for i in range(1, l):
            nextInt = max(nextInt, i+nums[i])
            if curr != l-1 and curr == i:
                curr = nextInt
                jumps += 1
        return jumps
