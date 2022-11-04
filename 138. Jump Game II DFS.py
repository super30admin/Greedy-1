class Solution:
    jumps = 0

    def jump(self, nums: List[int]) -> int:
        self.jumps = float("inf")
        if nums is None or len(nums) < 2:
            return 0
            # idx,j = jumps
        self.dfs(nums, 0, 0)
        return self.jumps

    def dfs(self, nums, idx, j):
        if j > self.jumps:
            return
        if idx >= len(nums) - 1:
            self.jumps = j
            return

        for i in range(1, nums[idx] + 1):
            self.dfs(nums, idx + i, j + 1)

# DFS
# Time Complexity: O(n^2)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : No, Time limit exceeded
# Any problem you faced while coding this : No
