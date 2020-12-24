#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums or len(nums) < 2:
            return True
        destination = len(nums)-1
        for i in range(len(nums)-1, -1, -1):
            if nums[i] + i >= destination:
                destination = i

        return destination == 0

#DFS - TC = Exponential
#     def dfs(self, nums, index):
#         if index == len(nums)-1:
#             return True
#         for j in range(1, nums[index]+1):
#             if self.dfs(nums, index+j):
#                 return True
#         return False

#     def canJump(self, nums: List[int]) -> bool:
#         if not nums or len(nums) < 2:
#             return True
#         return self.dfs(nums, 0)
