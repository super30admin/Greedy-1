"""
Time Complexity : Exponential without use of hashset. This is because for every index we are trying to reach out to every possible step. 
                  But in this case it is n^2 where n is the length of nums as we will traverse every node only once and in worst case we can jump to every other index from the current index resulting in n^2.
Space Complexity : O(2n) = O(n) where n is the length of nums, in worst case recursive stack can have all the elements of the nums and hashMap will also have all the elements

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""


class Solution:
    def __init__(self):
        self.hashMap = {}

    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n <= 1:
            return 0
        return self.dfs(nums, 0)

    def dfs(self, nums, i):
        # base
        if i == len(nums)-1:
            return 0
        if i in self.hashMap:
            return self.hashMap[i]

        # logic
        minJumps = float('inf')
        for j in range(1, nums[i]+1):
            if i + j < len(nums):
                newIdx = j + i
                jumps = self.dfs(nums, newIdx) + 1
                minJumps = min(minJumps, jumps)
        self.hashMap[i] = minJumps
        return minJumps
