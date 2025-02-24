'''
1. We travel in the reverse direction where our goal is actually to reach the last index from each index going right to left
2. At each index we reduce the goal to that index if we can reach the last index.
3. Eventually if we have the first index as the goal, it means we can reach the last index from it.

TC: O(n)
SC: O(1)
'''

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums or len(nums) == 0:
            return False
        
        goal = len(nums) - 1

        for i in range(len(nums)-1, -1, -1):
            if i + nums[i] >= goal:
                goal = i
        
        return True if goal == 0 else False

        