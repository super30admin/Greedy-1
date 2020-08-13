# Time Complexity : O(n) [n = length of input list]
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# 1. In curr_interval, I am trying to get closest to the end index
# 2. In next_interval, holds the maximum next interval for a current_interval
#   In other words, after taking the  jump where is my next interval
class Solution:
    def jump(self, nums: List[int]) -> int:
        if not nums or len(nums) < 2:return 0
        
        jumps = 1
        curr_index, next_index = nums[0], nums[0]
        
        for i in range(1, len(nums)):
            next_index = max(next_index, i+nums[i])
            if i < len(nums)-1 and i == curr_index:
                curr_index = next_index
                jumps+=1
        return jumps
"""
Important testcases
# Testcase - [3,4,2,1,1,2,2,1]
# Testcase - [2,3,2,2,0,4]
"""         
