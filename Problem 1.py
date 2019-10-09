# Time Complexity : O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        # If there is only one number return true
        if len(nums) == 1:
            return True
        # if no number then return false
        if nums[0] == 0:
            return False
        # lastpos stores the Good index  which means can we reach the last index from that index
        lastpos = len(nums) - 1

        # for each number from last to first check for the newer lastpos and update it
        for i in range(len(nums) - 1, -1, -1):
            if (i + nums[i]) >= lastpos:
                lastpos = i
        # if we got lastpos = 0 that means we can reach the end from index 0
        return lastpos == 0

