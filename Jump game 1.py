class Solution:
    def canJump(self, nums) :
        if nums == None or len(nums) <2:
            return True
        destination = len(nums)-1
        for i in range(len(nums)-2,-1,-1):
            if nums[i] + i >= destination:
                destination = i
        return destination == 0

