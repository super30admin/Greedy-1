# Approach:
# This problem can be solved using a greedy algorithm. We maintain a variable `max_reachable` to track the furthest index we can reach.
# We iterate through the array and at each position, we update `max_reachable` based on the current position and its jump length.
# If at any point, the `max_reachable` index is greater than or equal to the last index, we return true as it is possible to reach the last index.
# If we ever encounter a position where `max_reachable` is less than the current index, it means we are stuck and cannot move forward, so we return false.
# Time Complexity: O(n), where n is the length of the input array. We only need to iterate through the array once.
# Space Complexity: O(1), since we only use a few variables for tracking the current index and the maximum reachable index.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # Initialize the maximum reachable index to 0 (start at the first element)
        max_reachable = 0
        
        # Iterate through each index in the array
        for i in range(len(nums)):
            # If the current index is beyond the maximum reachable index, return false
            if i > max_reachable:
                return False
            
            # Update the maximum reachable index
            max_reachable = max(max_reachable, i + nums[i])
            
            # If we can reach or surpass the last index, return true
            if max_reachable >= len(nums) - 1:
                return True
        
        # If we finish the loop, check if we can reach the last index
        return max_reachable >= len(nums) - 1
