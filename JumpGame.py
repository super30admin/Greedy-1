# -*- coding: utf-8 -*-
"""
Created on Wed Mar 18 19:30:58 2020

@author: WELCOME
"""
"""
Jump Game 1
Time - O(N)
Space - O(1)
"""

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        destination=len(nums)-1
        
        for i in range(len(nums)-2,-1,-1):
            if i+nums[i]>=destination:
                destination=i
                
        return destination==0