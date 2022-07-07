'''
Time Complexity: 0(n)
Space Complexity: 0(1)
Run on leetCode: Yes
'''

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        # initlize ptrs
        target = len(nums)-1
        idx_behind = target-1
        
        # iterate till idx_behind isn't breeched
        while idx_behind > -1:
            # cal jumps
            jumps = nums[idx_behind]
            
            if idx_behind + jumps >= target:
                # update target
                target = idx_behind
            
            idx_behind -= 1
        '''end of iteration'''
        
        if target == 0:
            return True
        return False