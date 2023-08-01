# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
"""
The code works by starting at the end of the array and checking if the previous index can reach the current index. 
If it finds such an index it then looks similarly if that index can be reached by one of the previous indices.
"""

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        curr = len(nums) - 1
        while curr > 0:
            for index in range(curr - 1, -1, -1):
                if nums[index] >= curr - index:
                    curr = index
                    break
                if index == 0:
                    return False

        return True