#Time complexity: O(n)
#Space complexity is: O(1)
#Code ran successfully on leetcode
#No issues faced while coding

class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        #base condition
        if(len(nums)<2):
            return True
        #setting the target to len(nums)-1
        target=len(nums)-1
        #We will be iterating through the array
        for j in range(len(nums)-2,-1,-1):
            #We will check if we are able to reach the target or not
            if(nums[j]+j>=target):
                #We will update the target
                target=j
        #We will return True if we are able to reach the target
        return target==0
        