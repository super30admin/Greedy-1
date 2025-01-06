# The canJump method checks if it's possible to reach the last index of the array.

# Start from the end of the array and work backward:
# - Maintain a `goal` representing the furthest index that needs to be reached.
# - If the current index can jump to or beyond the goal, update the goal to the current index.

# Return True if the goal is the first index, otherwise False.

# TC: O(n) - Single traversal of the array.
# SC: O(1) - Constant space usage.


from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        goal = len(nums) - 1

        for i in range(len(nums) - 2, -1, -1):
            if i + nums[i] >= goal:
                goal = i
        return goal == 0