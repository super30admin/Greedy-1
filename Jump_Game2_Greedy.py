# Greedy
# Time complexity : O(n)
# Space complexity : O(1)

class Solution:
    def jump(self, nums: List[int]) -> int:
        # making default values for our pointers
        jump = 0
        farthest = 0
        end_of_last_jump = 0
        
        # traverse from the first index till the 2nd last index
        for current_jump in range(len(nums)-1):
          
            # first of all, we need to see how far can we go from the first index, which is the index + the value at index
            farthest = max(farthest, current_jump + nums[current_jump])
            
            # if we start from the initital index and reach it's end, only then we increment the jump
            # also update the end of last jump as the farthest as we need to reach the last index
            if current_jump == end_of_last_jump:
                jump += 1
                end_of_last_jump = farthest
        
        return jump
