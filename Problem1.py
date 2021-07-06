"""
// Time Complexity :o(n)
// Space Complexity : constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""
class Solution:
    def canJump(self, nums: List[int]) -> bool: #idea is to work backwards, we start from the last value and see if it is reachable by any of the elements before it
        
        dest = len(nums) - 1 
        
        for i in range(len(nums) - 2, -1, -1):
            if i + nums[i] >= dest: #if destination can be reached or can be surpassed, we update the destination to the current index as we have to see if now the current index can be reached or not
                dest = i
                
        if dest == 0: #in the end if we are able to reach 0th index that means input is valid
            return True
        return False
                
            