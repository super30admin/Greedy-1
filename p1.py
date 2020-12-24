#Time: O(N)
#space: O(1)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums is None or len(nums)==0:
            return False
        n = len(nums)
        reachable = 0 
        for i in range(n):
            if i > reachable:
                return False
            reachable = max(reachable,nums[i]+i)
        
        return True
            
        
