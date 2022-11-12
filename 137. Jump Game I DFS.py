class Solution:
    hashSet = {}

    def canJump(self, nums: List[int]) -> bool:
        if nums is None or len(nums) < 2:
            return True
        self.hashSet = set()
        return self.dfs(nums, 0)

    def dfs(self, nums, idx):
        # base
        if idx >= len(nums) - 1:
            return True

        # logic
        self.hashSet.add(idx)

        for j in range(1, nums[idx] + 1):
            if j + idx not in self.hashSet and self.dfs(nums, j + idx):
                return True
        return False
# DFS
# Time Complexity: O(n^2)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : No, Time Limit Exceeded
# Any problem you faced while coding this : No
