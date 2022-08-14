# Approach: two pointers approach
# TC O(n)
# SC O(1)
class Solution:
    def jump(self, nums: List[int]) -> int:
        res = l = r = 0
        
        
        while r < len(nums) - 1:
            # initialize farthest jump at reach step to 0
            farthest_jump = 0
            # loop from l to r
            for i in range(l, r+1):
                # at each step maximize farthest_jump by 
                # comparing it with i+nums[i]
                farthest_jump = max(farthest_jump, i+nums[i])
            # reset l to r+1 and r to farthest_jump
            l, r = r+1, farthest_jump
            # update res by 1
            res += 1
        
        return res