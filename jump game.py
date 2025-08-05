#Time complexity: O(N)
#Space Complexity: O(1)
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if len(nums) == 1:
            return True
        


        n = len(nums)
        target_index = n - 1

        for i in range(n-2,-1,-1):

            if nums[i] + i >= target_index:
                target_index = i
        
        return target_index == 0