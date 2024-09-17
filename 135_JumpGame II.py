'''
Accepted on leetcode(45)
time - O(N)
space - O(1)
Approach:
1. Check for edge case, if length of nums is 0 or 1.
2. declare variables
3. iterate over the array from 2nd element to calculate the minimum number of jumps.

'''


class Solution:
    def jump(self, nums) -> int:

        # edge case
        if len(nums) == 0 or len(nums) == 1:
            return 0

        # variables declaration
        nextInterval = nums[0]  # where the next interval ends.
        intervalMax = nums[0]  # until which number we have to check in this interval
        jump = 1

        # logic
        for i in range(1, len(nums)):

            # 1st condition
            if i + nums[i] > nextInterval:
                nextInterval = i + nums[i]

            # 2nd condition :if not the last index and index equals intervalMaximum
            if intervalMax == i and i != len(nums) - 1:
                intervalMax = nextInterval
                jump += 1

            if intervalMax >= len(nums) - 1:  # if last index reached.
                return jump