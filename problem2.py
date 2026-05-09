# problem 2 

# https://leetcode.com/problems/jump-game-ii/description/


class Solution:
    def jump(self, nums: List[int]) -> int:
        count = 0 
        n = len(nums)
        start_idx = 0
        end_idx = 0
        for i in range(n-1):
            start_idx = max(start_idx,i+nums[i])
            if i == end_idx:
                end_idx = start_idx 
                count+=1
        return count