#Time complexity: O(n)
#Space complexity: O(1)
class Solution:
    def jump(self, nums: List[int]) -> int:
        currInt,nextInt=nums[0],nums[0]
        if len(nums)==1:
            return 0
        jumps=1
        for i in range(1,len(nums)):
            nextInt=max(nextInt,i+nums[i])
            if(i!=len(nums)-1 and i==currInt):
                jumps+=1
                currInt=nextInt
                
        return jumps
        