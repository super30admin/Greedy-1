#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums) - 1
        target = n
        
        for i in range(n-1,-1,-1):
            
            if i + nums[i] >= target:
                target = i
                
        if target == 0:
            return True
        else:
            return False
            