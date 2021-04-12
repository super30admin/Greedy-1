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
    def jump(self, nums: List[int]) -> int:
        if not nums or len(nums) == 1:
            return 0
        jumps = 1
        currInterval = nums[0]
        nextInterval = nums[0]
        for i in range(1, len(nums)):
            nextInterval = max(nums[i] + i, nextInterval)
            if currInterval == i and i < len(nums) - 1:
                jumps += 1
                currInterval = nextInterval
        return jumps