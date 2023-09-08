#Time Complexity :O(n) 
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n=len(nums)
        target=n-1
        for i in range(n-1,-1,-1):
            if nums[i]+i>=target:
                target=i
        return target==0
        