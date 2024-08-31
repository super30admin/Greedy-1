#// Time Complexity : O(N) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No.

class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        jumps = 1
        currInt = nums[0]
        nextInt = nums[0]
        for i in range(len(nums)):
            nextInt = max(nextInt,nums[i] + i)
            if i == currInt:
                if i != len(nums)-1:
                    jumps += 1
                currInt = nextInt
        return jumps        


# Approach:
# The problem can be solved using a greedy approach. We start by initializing two variables, `currInt
# ` and `nextInt`, to the first element of the array. `currInt` represents the current
# reachable index, and `nextInt` represents the maximum reachable index from the current index.
# We then iterate over the array, updating `nextInt` to be the maximum of its current value and
# the sum of the current index and the current element. If the current index is equal to `curr
# `, we increment the `jumps` counter and update `currInt` to be `nextInt`.
