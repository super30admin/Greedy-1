# Time Complexity :  O(n)
# Space Complexity :O(1)
# Passed on Leetcode: yes

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        if n == 1:
            return True
        target = n-1
        for i in range(n-2, -1, -1):
            if i + nums[i] >= target:
                target = i
        
        return target == 0