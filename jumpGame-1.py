"""
Initially goal is last index. Check if it can be reached from prev index. if yes, next set the curr index as goal and repeat until last index
TC: O(n)
SP:O(1)
"""
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        goal = len(nums) - 1
        for i in range(len(nums) - 2, -1, -1):
            if i + nums[i] >= goal:
                goal = i
        return goal == 0
