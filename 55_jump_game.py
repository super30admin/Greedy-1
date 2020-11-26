"""
Leetcode: https://leetcode.com/problems/jump-game/
Approach 1: Greedy Algorithm - reverse traversal
Time Complexity: O(n). We are doing a single pass through the nums array, hence n steps,
where n is the length of array nums.
Space Complexity: O(1). We are not using any extra memory.
"""


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # base case
        if nums is 0 or len(nums) == 0:
            return True

        # last index is the destination
        destination = len(nums) - 1

        # iterate over given list in reverse order from second last index
        for x in reversed(range(destination)):
            # if index + num can reach the destination, update the dest with new index
            if x + nums[x] >= destination:
                destination = x

        # if destination reaches first index, return true
        return destination == 0



# Approach 2: Greedy Algorithm - forward traversal
# Compute at each point the maximum position max_pos that one could reach starting from the
#   current index i or before.
# Time Complexity: O(n). We are doing a single pass through the nums array, hence n steps,
#   where n is the length of array nums.
# Space Complexity: O(1). We are not using any extra memory.


# [0,1,2,3,4]
# [2,3,1,1,4]
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)  # 5

        # max position one could reach
        # starting from index <= i
        max_pos = nums[0]  # 2,4,8

        for i in range(1, n):  # 1,2,3,4
            # if one could't reach this point
            if max_pos < i:  # 2<1, 4<2, 4<3, 4<4
                return False
            max_pos = max(max_pos, nums[i] + i)  # (2,4)=4,(4,3)=4,(4,4)=4,(4,8)=8

        return True