class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        if nums is None or n < 2:
            return True
        goal = n-1
        for i in range(n-2, -1, -1):
            if (i + nums[i]) >= goal:
                goal = i
        return goal == 0
