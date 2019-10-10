#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Oct  8 10:25:49 2019

@author: tanvirkaur
"""

class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        time complexity = O(n)
        space complexity = O(n)
        """
        if len(nums)== 0 or len(nums) == 1:
            return 0
        currmax = nums[0]
        nextmax = nums[0]
        jump = 1
        for i in range(1,len(nums)):
            if i+nums[i] > nextmax:
                nextmax = i+ nums[i]
            else:
                nextmax = nextmax
            if currmax == i and i!= len(nums)-1:
                jump += 1
                currmax = nextmax
            if currmax >= len(nums)-1:
                break
        return jump