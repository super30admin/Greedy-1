# APPROACH - Greedy Solution
# Time Complexity : O(n), n: length of nums
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Basically trying to see if the destination is reachable from any of the ind. Then it goes on till we check if soe ind is reachable from start
# 2. Initially the destination is the last ind of nums. check from backwards if any of the ind, can be jumped from to rach this destination
# 3. If so, then we update the destination to that ind and check from there backwards for any ind which can be jumped from to reach this new destination
# 4. Keep doing this till you reach the destination as 0 (TRUE) or search ends at first index (FALSE)

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        if nums is None or len(nums) < 1:
            return False
        
        destination = len(nums) - 1
        for ind in range(len(nums) - 2, -1, -1):
            if ind + nums[ind] >= destination:
                destination = ind
                
        if destination == 0:
            return True
        else:
            return False
