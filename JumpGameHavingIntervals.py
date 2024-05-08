'''
TC O(n) - Used greedy to find the maximum distance with every window at every stage and determined 
        if we can jump over 0. n is the number of input array
SC O(1) - since we don't use any additional space
'''
from typing import List

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        currInt, nextInt = 0,0
        for i, num in enumerate(nums):
            nextInt = max(nextInt, num+i)
            if nextInt >= len(nums)-1:
                return True
            if currInt == nextInt == i:
                return False
            if currInt == i:
                currInt = nextInt
        return True
s = Solution()
print(s.canJump([2,3,1,1,4]))
print(s.canJump([3,2,1,0,4]))