# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Greedy Approach. Iterate over the nums array from backwards starting from second last index nums length - 2
# Set destination to last index in nums array
# Check if the element + its index >= destination then update destination to current index
# Return True if the destination becomes 0 else False


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums:
            return None
        destination = len(nums) - 1
        for i in range(len(nums) - 2, -1, -1):
            if nums[i] + i >= destination:
                destination = i

        return destination == 0
