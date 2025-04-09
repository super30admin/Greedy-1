# Problem 2 : Jump Game II
# Time Complexity : O(n) where n is the size of the nums list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def jump(self, nums: List[int]) -> int:
        # get the length of nums list
        length = len(nums)
        # if the length is less than 2 then return 0 since we are already at destination
        if length < 2:
            return 0
        # define variable current and next to value of 0th position
        currentInt = nums[0]
        nextInt = nums[0]
        # define jumps variable and set to 1
        jumps = 1
        # loop from 1 to length
        for i in range(1, length):
            # if the current is greater than or equal to last index then return jumps value
            if (currentInt >= length-1): return jumps
            # set the next as maximum of next and (i+ nums[i])
            nextInt = max(nextInt, i+nums[i])
            # if the current is i then set the current to next and increment the jumps by 1
            if (currentInt == i):
                currentInt = nextInt
                jumps += 1
        # return a big number
        return 99999
