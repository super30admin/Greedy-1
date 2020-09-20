# APPROACH: Greedy solution
# Time Complexity : O(n), n: length of jumps
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Here trying to get to the farthest index and also in minimum number of jumps
# 2. For each ind, check all the possibilities within the interval of the ind (from 1 to nums[ind] jumps). 
# 3. Consider the jump with maximum index (farthest one) as the next interval and increement the number of jumps
# 4. The point where the current interval hits the last index, return the number of jumps. 


class Solution:
    def jump(self, nums: List[int]) -> int:
        
        if nums is None or len(nums) < 2:
            return 0
        
        num_jumps, current_interval, next_interval = 1, nums[0], nums[0]
        
        for ind in range(1, len(nums)):
            if ind > current_interval:
                current_interval = next_interval
                num_jumps += 1
            next_interval = max(next_interval, ind + nums[ind])
            
            if current_interval == len(nums) - 1:
                break
                
        return num_jumps
