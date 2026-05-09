# problem 1

# https://leetcode.com/problems/jump-game/description/

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        last_ptr = n-1
        for i in range(n-1,-1,-1):
            if i + nums[i] >= last_ptr:
                last_ptr = i 
        if last_ptr == 0:
            return True 
        return False