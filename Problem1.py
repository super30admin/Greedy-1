# Problem1: Jump Game (https://leetcode.com/problems/jump-game/)
# Time Complexity: O(n),We use a single loop that runs backward from index n-2 down to index 0. Each index is visited exactly once and the work done inside the loop takes constant time. 
# Space Complexity: O(1)
# Approach: 
# Instead of moving forward and tracking the farthest reachable index, we flip the problem and move backward. We start by treating the last index as our target, since that is what we ultimately need to reach. 
#Then for every earlier position i, we ask: can I jump from position i to the current target or beyond it. This only depends on nums[i] and i, nothing else needs to be tracked.
# If position i can reach the target, position i becomes just as good as the target was, so we update target to i. This means target keeps shrinking toward index 0 whenever we find a position that connects to it
# If by the end target has been pulled all the way down to index 0, it means there is an unbroken chain of connections from index 0 to the last index, so a valid path exists.
# If target is still stuck above 0, some position failed to reach it, meaning the chain is broken and no path exists.

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)           # total number of elements in nums

        if n == 1:              # if there is only one element
            return True         # we are already at the last index, so return True

        target = n - 1         # we first need to reach the last index, so set it as target

        for i in range(n - 2, -1, -1):  # loop backward from second last index down to index 0
            if nums[i] + i >= target:   # check if position i can jump to or beyond the target
                target = i           # if yes, position i becomes the new target, our nearest stepping stone

        return target == 0          # if target was pulled all the way to index 0, a valid path exists
            