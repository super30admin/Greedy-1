'''
TC O(n) - Used greedy to find the maximum distance at every stage and determined 
        if we can jump over 0. n is the number of input array
SC O(1) - since we don't use any additional space
'''
from typing import List

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) == 1:
            return True
        maxIdx = 0
        for i, num in enumerate(nums):
            if num == 0 and maxIdx == i:
                return False
            maxIdx = max(num+i, maxIdx)
            if maxIdx >= len(nums)-1:
                return True
        return False
s = Solution()
print(s.canJump([2,3,1,1,4]))
print(s.canJump([3,2,1,0,4]))