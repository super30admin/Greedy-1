#Time Complexity :O(n) 
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums)<2:
            return 0
        currInt=nums[0]
        nextInt=nums[0]
        jump=1
        for i in range(len(nums)):
            nextInt=max(nextInt,nums[i]+i)
            if i!=len(nums)-1 and i==currInt:
                currInt=nextInt
                jump+=1
        return jump
