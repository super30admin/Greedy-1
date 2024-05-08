'''
TC O(n) - Used greedy to find the maximum distance with every window at every stage and determined 
        if we can jump over 0. Jumps are incremented based on the window.
        n is the number of input array
SC O(1) - since we don't use any additional space
'''
from typing import List

class Solution:
    def jump(self, nums: List[int]) -> int:
        jumps = 0
        if len(nums) == 1:
            return jumps
        currInt, nextInt = 0,0
        for i, num in enumerate(nums):
            nextInt = max(nextInt, num+i)
            if nextInt >= len(nums)-1:
                return jumps+1
            if i == currInt:
                currInt = nextInt
                jumps += 1
s = Solution()
print(s.jump([2,3,1,1,4]))
print(s.jump([2,3,0,1,4]))