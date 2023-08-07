# Time complexity - O(n)
#  Space complexity - O(1)
class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums)<2:
            return 0
        
        nextInt=nums[0]
        currInt=nums[0]
        jumps=1
        for i in range(len(nums)-1):
            nextInt=max(nextInt,i+nums[i])
            if(i == currInt):
                currInt=nextInt
                jumps+=1
        
        return jumps
