"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""



class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_dest = float("-inf")
        pos = 0
        
        for i in range(len(nums) - 1):
            # calculate the max dest from that index
            max_dest = max(max_dest, i + nums[i])
            
            # will get with min jump to reach destination
            if pos == i:
                pos = max_dest
        
        # check if I have reached destination
        if pos >= len(nums) -1:
            return True
        return False
