# Time Complexity :O(N)
# Space Complexity :O(1)
# Changing our target greedily

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        target = n - 1
        for i in range(n-2, -1, -1):
            if i + nums[i] >= target:
                target = i
                
        if target == 0:
            return True
        
        else:
            return False
