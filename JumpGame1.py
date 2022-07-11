#Time complexity: O(n)
#Space complexity: O(1)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        target=len(nums)-1
        if len(nums)==1:
            return True
        for i in range(len(nums)-2,-1,-1):
            curr=nums[i]
            if curr+i >= target:
                target=i
        return target==0
        