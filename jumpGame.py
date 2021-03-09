# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums:
            return True
        n = len(nums)
        dest = n - 1
        for i in range(n-2, -1,-1):
            if i + nums[i] >= dest:
                dest = i
                
        return dest == 0