'''
MinHeap
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: To find the shortest path from starting to end, we first iterate through the levels of the path by using
the variable scope, ie if we cross scope this means that we passed one level and hence increase the new scope would be
farthest, farthest is the max index we can reach from a point provided the jumps. If we reach the end of the array then
return jumps +1
'''
class Solution:
    def jump(self, nums: List[int]) -> int:

        if len(nums) == 1:
            return 0

        jumps = 0
        scope = 0
        farthest = 0

        for i in range(0, len(nums)):
            farthest = max(farthest, i + nums[i])
            if farthest >= len(nums) - 1:
                return jumps + 1

            if i == scope:
                jumps += 1
                scope = farthest