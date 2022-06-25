class Solution:
    def jump(self, nums: List[int]) -> int:
        if not nums or len(nums)<=1:
            return 0
        
        jumps, currInt, nextInt = 0, 0, 0
        
        for i in range(len(nums)):
            if (i+nums[i]>nextInt):
                nextInt=i+nums[i]
                
            if i==currInt:
                currInt=nextInt
                jumps+=1
            
            if currInt>=len(nums)-1:
                break
                
        return jumps
        