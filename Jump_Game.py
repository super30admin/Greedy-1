#TC:O(n)
#Sc:O(1)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums)<=1:
            return True
        distance = 1
        for i in range(len(nums)-2,-1,-1):
            if nums[i]>=distance:
                distance = 1
            else:
                distance+=1
        return True if distance==1 else False