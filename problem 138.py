# https://leetcode.com/problems/jump-game/

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_reach = 0 # max we can reach 
        n = len(nums)
        for i in range(n):
            if i > max_reach: # to ckeck if it can reach till the i or not
            # if not then we can't reach end also 2nd example for this case
                return  False
            # update max_reach 
            max_reach = max(max_reach,i+nums[i])
            if max_reach >= n-1: # check if it crosses last element
                return True
        return False

#TC: O(N)
#SC: O(1)