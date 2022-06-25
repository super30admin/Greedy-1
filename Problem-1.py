class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums or len(nums)==0:
            return 0
        destination=len(nums)-1
        for i in range(len(nums)-2,-1,-1):
            if (nums[i]+i>=destination):
                destination=i
                
        return destination==0