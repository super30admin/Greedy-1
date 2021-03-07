class Solution:
    
    """
    Description: From jump game, find minimum jumps
    
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Approach: Using Greedy approach:
    - start with jump = 1 (for length of array > 1)
    - for each index, move two zones, current interval and next interval
      + update current interval to next when we reach to end of previous current interval and add a jump
      + next interval will always be maximum index of the jump could be taken from previous
    - ensure to limit updating the current interval only for indices less than the last index
    """
    
    def jump(self, nums: List[int]) -> int:
        
        if nums == None or len(nums) < 2: return 0
        jump = 1 # min jump for length > 1
        next_interval = nums[0]; curr_interval = nums[0]
        
        for i, num in enumerate(nums):
            next_interval = max(i + num, next_interval)
            if i == curr_interval and i < len(nums) - 1: 
                jump += 1
                curr_interval = next_interval
            
        return jump
            
