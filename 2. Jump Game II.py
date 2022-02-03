class Solution:
    # Time Complexity - O(n)
    # Space Complexity - O(1)
    def jump(self, nums) -> int:
        n = len(nums)
        i = 0
        maxReachable = 0
        lastJumpedPos = 0
        jumps = 0

        while lastJumpedPos < n - 1:
            maxReachable = max(maxReachable, i + nums[i])
            if i == lastJumpedPos:
                lastJumpedPos = maxReachable
                jumps += 1
            i += 1

        return jumps