# Problem2: Jump Game II (https://leetcode.com/problems/jump-game-ii/)
# Time Complexity: O(n),We loop through the array once from index 1 to n-1, doing constant work at each step, so the total time grows linearly with the size of nums.
# Space Complexity: O(1), We only use a few variables, no extra data structures are used.
# Approach: We use a greedy approach to track the farthest index we can jump to at every step.
# We use max_int to record the farthest index reachable if we take one more jump from any index we have visited so far.
# curr_int tracks the farthest index reachable using the jumps we have already committed to, this is our current jump range.
# As soon as we reach the edge of our current range (i == curr_int), we know we must commit to another jump right now, so we increment jump count and extend curr_int to max_int.
# We skip incrementing jump if we are already at the last index, since no further jump is needed once we reach the end.

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)       # total number of elements in nums, this is how far we need to travel

        if n == 1:
            return 0        # already at the last index, so no jumps are needed

        max_int = nums[0]       # farthest index reachable so far as we scan forward
        curr_int = nums[0]      # farthest index reachable using jumps already counted, our current jump range
        jump = 1                # we assume at least one jump is needed to leave index 0

        for i in range(1, n):               # start scanning from index 1 since we are already standing at index 0
            max_int = max(max_int, i + nums[i])  # update farthest reachable index if jumping from i goes farther

            if i != n - 1 and i == curr_int:        # check if we hit the edge of our current range, and we are not at the last index yet
                jump += 1               # commit to another jump since we can not go farther without one
                curr_int = max_int           # extend our range to the farthest point discovered while exploring the previous range

        return jump  # minimum number of jumps required to reach the last index

        