class Solution:
    def canJump(self, nums: List[int]) -> bool:
        reachable_ind = 0
        for ind, val in enumerate(nums):
            if ind > reachable_ind:
                return False
            reachable_ind = max(reachable_ind, ind + val) 
            
        return True

%TC:O(n)
%SC:O(1)