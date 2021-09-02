class Solution:
    def jump(self, nums):
        if nums==None or len(nums)<2:
            return 0
        jumps=1
        curr=nums[0]
        nextt=nums[0]
        for i in range(1,len(nums)):
            nextt=max(nextt,nums[i]+i)
            if i<len(nums)-1 and i>=curr:
                jumps+=1
                curr=nextt
        return jumps