# Time Complexity: O(n), where n - length of the input array
# Space Complexity: O(1)

class Solution:
    def jump(self, nums: List[int]) -> int:
        if not nums or len(nums) < 2:
            return 0

        n = len(nums)
        current_jump_end = 0
        farthest = 0
        jumps = 0

        for i in range(n - 1):
            # Find how far we can reach the current jump
            farthest = max(farthest, i + nums[i])

            # If end of curr jump is reached, take next jump
            if i == current_jump_end:
                current_jump_end = farthest
                jumps += 1

        return jumps