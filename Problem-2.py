#Time Complexity :o(n)
#Space Complexity :o(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if(nums==None or len(nums)<2):
            return 0
        
        nextInter,currInter=nums[0],nums[0]
        jump=1
        for i in range(1,len(nums)):
            nextInter=max(nextInter,nums[i]+i)
            #reset the next currInter
            if(i<len(nums)-1 and currInter==i):
                currInter=nextInter
                jump+=1
        return jump