"""
Time Complexity : O(n) where n is the length of nums
Space Complexity : O(1) as no auxillary data structure is used

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach
1. Initially, set the destination to n-1
2. We can start from the n-2 index and will check if we can reach the destination, if we can then update the destination to the current Index
3. At the end if destination is 0 then return True else False. destination 0 indicates that it is possible to reach the last index from 0th index.
"""


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        if n <= 1:
            return True
        destination = n - 1
        for i in range(n-2, -1, -1):
            if i + nums[i] >= destination:
                destination = i

        return True if destination == 0 else False
