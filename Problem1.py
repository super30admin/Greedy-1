# Problem 1 : Jump Game
# Time Complexity : O(n) where n is the size of nums array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    
    def canJump(self, nums: List[int]) -> bool:
        # get the length of nums list
        length = len(nums)
        # if the length is less than 2 then return True
        if length < 2:
            return True
        # set the target variable as length - 1
        target = length - 1
        # loop from second last element to first element in the nums list
        for j in range(length-2, -1, -1):
            # if the value (j + nums[j]) is greater than target means we can reach to target from jth position in nums list
            if (j + nums[j] >= target):
                # set the target as jth position
                target = j
        # if the target is 0 means we reach destination
        if target == 0:
            # if we can reach then return True
            return True
        else:
            # else return False
            return False
