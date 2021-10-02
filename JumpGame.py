"""
Time Complexity : O(n) where n is the number of elements in nums array
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) == 0 or len(nums) < 2:
            return True
        n = len(nums)
        destination = n - 1
        # Start traversing from the last second element of the array and update the 
        # destination to that particular index whenever we have sum of index and 
        # element at that index greater than or equal to current destination as we can         # do that many jumps 
        for i in range(n - 2, -1, -1):
            if nums[i] + i >= destination:
                destination = i
        return destination == 0