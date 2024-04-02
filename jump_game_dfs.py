"""
Time Complexity : Exponential without use of hashset. This is because for every index we are trying to reach out to every possible step. 
                  But in this case it is n^2 where n is the length of nums as we will traverse every node only once and in worst case we can jump to every other index from the current index resulting in n^2.
Space Complexity : O(2n) = O(n) where n is the length of nums, in worst case recursive stack can have all the elements of the nums and hashset will also have all the elements

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
We can do the dfs and if we reach to the last index of nums we will return True otherwise at the end return False 
"""


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) <= 1:
            return True
        hashSet = set()
        return self.dfs(nums, 0, hashSet)

    def dfs(self, nums, i, hashSet):
        # base
        if i == len(nums)-1:
            return True

        # logic
        hashSet.add(i)
        for j in range(1, nums[i]+1):
            newIdx = i + j
            if newIdx not in hashSet and self.dfs(nums, newIdx, hashSet):
                return True
        return False
