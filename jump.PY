"""
TC O(N)
SC O(1)

"""

class Solution:
    def jump(self, nums: List[int]) -> int:
        if not len(nums) or len(nums)<2:
            return 0
        currInt=nums[0]
        nextInt=nums[0]
        jumps=1
        for i in range(1,len(nums)):
            nextInt=max(nextInt,i+nums[i])
            #currInt!=len(nums)-1 and i==currInt
            if(i<len(nums)-1 and i==currInt):
                currInt=nextInt
                jumps+=1
        return jumps
        