class Solution:
    def jump(self, nums: List[int]) -> int:
        # T: O(n), S: O(1)
        n = len(nums)
        if n == 1:
            return 0  # Already at last index

        jumps = 0
        curr_end = 0
        max_reach = 0

        for i in range(n - 1):  # Don't need to jump from the last index
            max_reach = max(max_reach, i + nums[i])

            if i == curr_end:  # Need to jump
                jumps += 1
                curr_end = max_reach

                if curr_end >= n - 1:
                    break  # We can reach the last index

        return jumps
