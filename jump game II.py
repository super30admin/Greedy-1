#Time complexity: O(N)
#Space Complexity: O(1)
# BFS, Interval Greedy
class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        jump = 0
        l , r = 0,0
        while r < len(nums) - 1:
            fathest_idx = 0
            for i in range(l,r + 1):
                fathest_idx = max(fathest_idx,nums[i] + i)
            l = r + 1
            r = fathest_idx
            jump += 1
        
        return jump



        
        