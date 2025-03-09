# In this approach, we greedily check if we can reach the end of the array by keeping track of the maximum index we can reach at each step.
# Time Complexity: O(N)
# Space Complexity: O(1)

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        if n == 1:
            return True
        max_jump = nums[0]
        for i in range(1, n):
            if max_jump >= i:
                max_jump = max(i + nums[i], max_jump)
                if max_jump >= n-1:
                    return True
            
        return False