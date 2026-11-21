# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Greedy Approach. Set maxReach to 0 and iterate over the nums array
# Check if the i > maxReach then return False
# Set maxReach to max between maxReach and current element + i
# Check if the maxReach >= length of array - 1 then return True that means we have reached last index in array
# Return False


class Solution:
    def canJump(self, nums: list[int]) -> bool:
        if len(nums) == 1:
            return True
        maxReach = 0
        for i in range(len(nums)-1):
            if i > maxReach:
                return False
            maxReach = max(maxReach, i + nums[i])
            if maxReach >= len(nums)-1:
                return True
        return False