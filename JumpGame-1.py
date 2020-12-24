# DFS
# Time - exponential
# Space - O(1)
# Des - explore each every path by incrementing +1 from 1 to the value at that index
# Greedy
# Time - O(n)
# Space - O(1)
# Des - grredy approch from backwards where last index is the destination, if the sum of index and value at that index is greater than des then update des and move the point by -1.

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        #     #DFS - TLE
        if len(nums) < 2:
            return True
        #     def dfs(nums,index):
        #         if index==len(nums)-1:
        #             return True
        #         for i in range(1,nums[index]+1):
        #             if dfs(nums,index+i):
        #                 return True
        #         return False
        #     return dfs(nums,0)

        des = len(nums) - 1
        for i in range(len(nums) - 2, -1, -1):
            if i + nums[i] >= des:
                des = i
        return des == 0
