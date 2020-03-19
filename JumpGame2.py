# -*- coding: utf-8 -*-
"""
Created on Wed Mar 18 19:33:07 2020

@author: WELCOME
"""
"""
Jump Game 2
Time - O(N^2)
Space - O(N)
"""
class Solution:
    def jump(self, nums: List[int]) -> int:
        dpMemo={}
        def recursion(index):
            if index in dpMemo:
                return dpMemo[index]
            if index>=len(nums)-1:
                return 0
            if index<len(nums):
                a=float('inf')
                for i in range(index+1,index+1+nums[index]):
                    if i<len(nums):
                        a=min(a,recursion(i))
                dpMemo[index]=a+1
                return a+1
        return recursion(0)