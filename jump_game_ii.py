# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
"""
The code works by checking from the end what is the farthest index that can be used to reach the current index. 
And it does that iteratively to keep track of the minimum number of jumps required to reach the end.
"""

class Solution:
    def jump(self, nums: List[int]) -> int:
        curr = len(nums) - 1
        answer = 0
        while curr != 0:
            for index in range(curr):
                if index + nums[index] >= curr:
                    curr = index
                    answer += 1
                    break

        return answer