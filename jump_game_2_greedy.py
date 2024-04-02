"""
Time Complexity : O(n) where n is the length of nums
Space Complexity : O(1) as no auxillary data structure is used

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach
The idea is to reach out to the index which is closest to the end index from the current index. 
1. To to this, use two variables, currInterval and nextInterval
2. Initialized to nums[0]
3. Update currInterval at the end of the currInterval to the nextInterval
4. Update the nextInterval = max(nextInterval, i+nums[i]) == reaching out to the index closest to the end index
"""


class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n <= 1:
            return 0
        currInterval = nums[0]
        nextInterval = nums[0]
        jumps = 1

        for i in range(1, n):
            nextInterval = max(nextInterval, i+nums[i])
            if i == currInterval and i != n-1:
                jumps += 1
                currInterval = nextInterval

        return jumps
