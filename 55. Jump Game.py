#Time Complexity:O(n)
#Space Complexity:O(1)

class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        dest=len(nums)-1
        for i in range(len(nums)-2,-1,-1):
            if i+nums[i]>=dest:
                dest=i
        if dest==0:
            return True
        return False
