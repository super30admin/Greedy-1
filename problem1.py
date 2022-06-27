class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if(len(nums)==1):
            return True
        steps = 1
        
        for i in range(len(nums)-2,-1,-1):
            if(nums[i]>=steps):
                steps=1
            else:
                steps+=1
        return nums[0]>=steps