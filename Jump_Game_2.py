# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Greedy Approach. Set currInterval and nextInterval to first element in nums array
# Iterate over the nums array starting from index 1 and update nextInterval to max between nextInterval and current element + index of current element
# That is the max jump we can take from current element
# Check if the currInterval == current index and current index < last index in nums array then update currInterval to nextInterval and increment jumps by 1
# Return jumps


class Solution:
    def jump(self, nums: list[int]) -> int:
        if len(nums) == 1:
            return 0
        maxReach = 0
        jumps = 1
        currInt = nums[0]
        nextInt = nums[0]
        for i in range(1, len(nums)):
            nextInt = max(nextInt, nums[i] + i)
            if i != len(nums)-1 and i == currInt:
                jumps += 1
                currInt = nextInt
        return jumps