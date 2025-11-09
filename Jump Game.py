#  Time Complexity : O(N)   
#  Space Complexity : O(1)  
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english: We traverse backwards in this code. Starting from the second last element we check if nums[i] + i is greater than the target. If the maximum element we can reach is greater than or equal to the target then that index becomes the new target. If finally the target becomes 0 then we can reach tghe target.


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # TC: O(n) SC: O(1)
        n = len(nums)
        if n == 1:
            return True
        
        target = n - 1
        
        for i in range(n - 2, -1, -1):
            if nums[i] + i >= target:
                target = i
        
        return target == 0
