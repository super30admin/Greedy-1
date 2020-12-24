#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def jump(self, nums: List[int]) -> int:
        if not nums or len(nums) < 2:
            return 0
        currInterval, nextInterval, jumps = nums[0], nums[0], 1
        for i in range(1, len(nums)):
            nextInterval = max(nextInterval, nums[i] + i)
            if currInterval != len(nums)-1 and currInterval == i:
                currInterval = nextInterval
                jumps += 1
        return jumps

#     def dfs(self, nums, index, jump):
#         if index >= len(nums)-1:
#             self.min = min(self.min, jump)
#             return

#         for j in range(1, nums[index]+1):
#             self.dfs(nums, index+j, jump+1)

#     def jump(self, nums: List[int]) -> int:
#         if not nums or len(nums) < 2:
#             return 0
#         self.min = float("inf")
#         self.dfs(nums, 0, 0)
#         return self.min
