class Solution:
    def jump(self, nums: List[int]) -> int:
        if nums is None or len(nums) < 2:
            return 0
        # first element will the size of the next interval and current interval
        nextInt = nums[0]
        currInt = nums[0]
        # intially jumps will be 1
        jumps = 1
        # iterating through the nums array from index 1 to second last index
        # second last index cause at the last index i and currInt will be same and
        # will end up adding 1 extra jump
        for i in range(1, len(nums) - 1):
            # updating the next interval by taking max optimal
            nextInt = max(nextInt, i + nums[i])
            # update currInt and jumps when we have iterated through all the elements
            # in the current window
            if i == currInt:
                currInt = nextInt
                jumps += 1
            # print(i, nums[i], currInt, nextInt)
        return jumps

# Greedy
# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
