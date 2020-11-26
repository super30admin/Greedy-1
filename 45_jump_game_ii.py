"""
Leetcode: https://leetcode.com/problems/jump-game-ii/
Approach: Greedy Algorithm.
    1. Initiate the maximum position that one could reach starting from the current index i or before: max_pos = nums[0].
    2. Initiate the maximum position reachable during the current jump: max_steps = nums[0].
    3. Initiate number of steps: at least one, if array has more than 1 cell.
    4. Iterate over number of elements in the input array:
        a. If max_step < i, one needs one more jump: jumps += 1. To minimize the number of jumps, choose the longest possible one: max_steps = max_pos.
        b. Update max_pos = max(max_pos, i + nums[i])
    5. Return the number of jumps.

Time complexity: O(N), it's one pass along the input array.
Space complexity: O(1) since it's a constant space solution.
"""


# [0,1,2,3,4]
# [2,3,1,1,4]
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)  # 5

        # for n < 2, number of steps to reach last index is 0
        if n < 2:
            return 0

        # max position one could reach starting from index <= i
        max_pos = nums[0]  # 2,4

        # max number of steps one could do inside this jump
        max_steps = nums[0]  # 2,4

        # start traversal with jump
        jumps = 1  # 1,2

        for i in range(1, n):  # 1,2,3,4
            # to reach this point one needs one more jump
            if max_steps < i:  # 2<1,2<2,2<3,4<4
                jumps += 1  # 2
                max_steps = max_pos  # 4

            max_pos = max(max_pos, nums[i] + i)  # (2,4)=4,(4,3)=4,(4,4)=4,(4,8)=8

        return jumps