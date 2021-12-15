# Time Complexity: O(n), where n - length of the input array
# Space Complexity: O(1)

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums or len(nums) < 2:
            return True

        n = len(nums)

        # Start from the last index
        destination = n - 1

        # Check if every local desination can be reached from any of its previous indices
        for i in range(n - 2, -1, -1):
            if i + nums[i] >= destination:
                destination = i

        # If destination reaches start index, return true
        return destination == 0