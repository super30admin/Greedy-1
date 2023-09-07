# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this problem run on Leetcode: Yes
# Any issues faced doing this problem: No

class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        x = [nums[i] + i for i in range(len(nums))]  
        l, r, jumps = 0, 0, 0
        while r < (len(nums) - 1) :
            jumps += 1
            l, r = (r + 1), max(x[l:r + 1]) 
        return jumps