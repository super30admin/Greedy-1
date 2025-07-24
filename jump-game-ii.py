# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return 0
        
        jumps = 0
        current_end = 0  # The farthest position we can reach with current jumps
        farthest = 0     # The farthest position we can reach from current position
        
        for i in range(len(nums) - 1):
            # Update the farthest position we can reach from current position
            farthest = max(farthest, i + nums[i])
            
            # If we've reached the current end, we need another jump
            if i == current_end:
                jumps += 1
                current_end = farthest
                
                # If we can reach the end, we're done
                if current_end >= len(nums) - 1:
                    break
        
        return jumps
        