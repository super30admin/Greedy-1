# Time: O(n)
# Space: O(n)
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        d = len(nums) - 1
        for i in range(len(nums)-2, -1, -1):
            if nums[i] >= d-i:
                d = i
        return d==0
        
