# Approach:
# This problem can be solved using a greedy algorithm. The idea is to always try to make the longest jump possible at each step.
# We maintain three variables:
# - `jumps`: to count the number of jumps required to reach the last index.
# - `current_end`: to track the farthest index we can reach with the current number of jumps.
# - `farthest`: to track the farthest index we can reach with the next jump.
# We iterate through the array and at each index, we update `farthest`. When we reach `current_end`, we increment the `jumps` counter and update `current_end`.
# This ensures that we make the minimum number of jumps required.
# Time Complexity: O(n), where n is the length of the input array. We only need to iterate through the array once.
# Space Complexity: O(1), since we only use a few variables for tracking the number of jumps and the current farthest reachable index.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def jump(self, nums: List[int]) -> int:
        # Initialize variables for the number of jumps, current end of the jump, and farthest reachable index
        jumps = 0
        current_end = 0
        farthest = 0
        
        # Iterate through the array, except for the last index (since we don't need to jump from there)
        for i in range(len(nums) - 1):
            # Update the farthest index we can reach from the current position
            farthest = max(farthest, i + nums[i])
            
            # If we've reached the end of the current jump, increment the jump counter
            if i == current_end:
                jumps += 1
                current_end = farthest
                # If the current_end is at or beyond the last index, we can stop
                if current_end >= len(nums) - 1:
                    break
        
        return jumps
