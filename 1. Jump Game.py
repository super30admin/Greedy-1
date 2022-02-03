class Solution:
    # Time Complexity - O(n)
    # Space Complexity - O(1)
    def canJump(self, nums):
        if nums is None or len(nums) < 2: return True
        n = len(nums)
        destination = n - 1
        for i in range(n - 2, -1, -1):
            if nums[i] + i >= destination:
                destination = i

        return destination == 0