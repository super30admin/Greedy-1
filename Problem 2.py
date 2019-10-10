# Time Complexity : O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) <= 1:
            return 0
        # currMax stors the max jump possible for the present index
        currMax = nums[0]
        # nextMax stores the max jump possible for a number from the index to its currMax
        nextMax = nums[0]
        jump = 1

        for i in range(len(nums)):
            # we find the max jump ossible in the range of number to its currMax( that is i +nums[i])
            nextMax = max(nextMax, i + nums[i])
            # if the pointer reached the max reachable number for the current number in a single jump then increase jump and change crrMax to nextMax
            if i == currMax:
                jump += 1
                currMax = nextMax
            # if the currMax is going beyond the lenght then we got the ans
            if currMax >= len(nums) - 1:
                return jump