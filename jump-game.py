# Time Complexity: O(n)
# Space Complexity: O(1)
# Approach: Greedily pick the furthest position you can reach from a given index. At the end check if the furthest you ccan reach is the end of the array.
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        i, furthest = 0, 0
        while i <= furthest and furthest < len(nums):
            furthest = max(furthest, nums[i] + i)
            i += 1
        
        return furthest >= len(nums) - 1