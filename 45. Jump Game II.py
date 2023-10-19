#Time Complexity:O(n)
#Space Complexity:O(1)

class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==1 or len(nums)==0:
            return 0
        jump=1
        currInterval=nums[0]
        nextInterval=nums[0]
        for i in range(len(nums)):
            nextInterval=max(nextInterval,i+nums[i])
            if i<len(nums)-1 and i==currInterval:
                jump=jump+1
                currInterval=nextInterval
        return jump
