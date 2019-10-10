#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Oct  8 10:25:44 2019

@author: tanvirkaur
"""

class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        time complexity = O(n)
        space complexity = O(n)
        """
        if len(nums) == 0 or len(nums) == 1:
            return True
        end = len(nums)-1
        for i in range(0,len(nums)-2):
            if i + nums[i] >= end:
                return True
            i += 1
        return False
    