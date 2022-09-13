# TC: O(n)
# SC: O(1)
# Did this code successfully run on Leetcode : Yes
# Greedy Approach
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # base case
        if len(nums) == 1: return True 
        
        dest = len(nums) - 1
        for i in range(len(nums) - 2, -1, -1):
            if i + nums[i] >= dest:
                dest = i
                if dest == 0:
                    return True
        return False