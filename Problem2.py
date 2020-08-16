"""
// Time Complexity :o(n)
// Space Complexity : constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""
class Solution:
    def jump(self, nums: List[int]) -> int:
        if not nums or len(nums) < 2: 
            return 0
        
        jumps = 1 #if length is more than 1, then at least 1 jump is required
        cur_int = next_int = nums[0] #initial values
        
        for i in range(1,len(nums)):
            if nums[i] + i > next_int: #setting next interval to the next max value
                next_int = nums[i] + i 
                
            if i < len(nums)-1 and i == cur_int:#if we have visited all the values in current interval, and current interval isnt till the last index
                cur_int = next_int #update cur_int and increase jump 
                jumps += 1
                
        return jumps