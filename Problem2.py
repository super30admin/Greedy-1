class Solution:
    
      """
    
            Name : Shahreen Shahjahan Psyche
            Language Used : Python
            Time : O(N)
            Space: O(1)
            Passed All The Test Cases in LC : Yes
            
            Approach : # Start from the source and try to maximize the current and next intervals
                       # start walking from position 1 and check whether current max jump takes me closer to source and record it in next interval. 
                       # Go to the next step and again take the maximum jump and if it is greater than the previous next interval, update next inteerval
                       # do this until we reach to current interval. 
                       # if we reach to the current interval, we updatee our current interval to next interval and incrase jump by 1. Also, make sure that current 
                         interval is not in the destination, casue we dont need to increase the jump in that case
                       # return the jump
                       
                        
                       
    
    """
    
    def jump(self, nums: List[int]) -> int:
        
        # edge case
        if len(nums) == 1:
            return 0
        
        curr_int = nums[0]
        next_int = nums[0]
        jump = 1
        for i in range(1, len(nums)):
            next_int = max(nums[i]+i, next_int)
            if i < len(nums)-1 and i == curr_int:
                jump += 1
                curr_int = next_int
                
                
        return jump
                
