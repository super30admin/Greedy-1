#Time Complexity :o(n) 
#Space Complexity :o(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if(nums==None or len(nums)<2):
            return True
        
        n=len(nums)
        dest=n-1
        for i in range(n-2,-1,-1):
            if(nums[i]+i>=dest):
                dest=i
        
        if(dest==0):
            return True
        return False