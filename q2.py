# Time Complexity : O(n), Where n is number of elements in nums List
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from typing import List
class Solution:
    def jump(self, nums: List[int]) -> int:
        #Edge Case
        if(len(nums)<=1):
            return 0
        
        jumps=1#This is because we have already the in the currint
        currint=nums[0]#Here currint will have ending index of the current window
        nextint=0#Here nextint will have the starting index of the next window
        n=len(nums)
        for i in range(1,n):
            nextint=max(nextint,i+nums[i])
            if(i<n-1 and i==currint):
                #When we reach the end of the current window, Then modify the window
                currint=nextint
                jumps+=1
        return jumps
        