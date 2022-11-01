#Time: O(n)
#Space: O(1)
#Program ran on leetcode successfully

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) < 2:
            return True
        
        target = len(nums) - 1
        for i in reversed(range(len(nums) - 1)):
            if i + nums[i] >= target:
                target = i
        
        return target == 0
        