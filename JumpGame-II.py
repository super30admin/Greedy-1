"""
Time Complexity : O(n) where n is the number of elements in nums array
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) == 0 or len(nums) < 2:
            return 0
        n = len(nums)
        # Set current and farthest pointers as first element
        curr = farthest = nums[0]
        jumps = 1
        # Traverse through the array and update farthest only when we find anything
        # greater than our current farthest value. Whenever we reach the decided
        # jump value we reset the current pointer to our farthest and increment the 
        # jumps
        for i in range(n):
            farthest = max(farthest, nums[i] + i)
            if i < n - 1 and curr == i:
                curr = farthest
                jumps += 1
        return jumps