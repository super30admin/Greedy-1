#  https://leetcode.com/problems/jump-game-ii/

class Solution:
    def jump(self, nums: List[int]) -> int:
        near = far = jumps = 0

        while far < len(nums) - 1: # as lond as the right pointer doesnt reach last element we need to do this
            farthest = 0
            for i in  range(near, far+1): # Setting a range to check which jump is the best to make
                farthest = max(farthest, i+ nums[i])

           # after deciding which is the best to make  
           # we set our boundaries there
            near = far + 1 # left pointer
            far = farthest # right
            jumps += 1 # no of jumps in reaching that step
        return jumps

# TC: O(n) althought there are 2 loops this is kind of sliding window
# the inner loop just simply is checking for a certain range and the outer loop starts after that

# SC: O(1)
        