# Time Complexity : O(n)
# Space Complexity : O(1)
class Solution:
    def canJump(self, nums):
        if not nums:
            return False
        
        jump , n = 0, len(nums)

        for i in range(n):
            # If we've reached an index that is not reachable, return false
            if i > jump:
                return False

            # Update the maximum reachable index
            jump = max(jump, i + nums[i])

            # If we've reached the end of the array, return true
            if jump >= n - 1:
                return True

        # If we've exited the loop without returning, then we can't reach the
        # end
        return False

# Examples and Analysis

# Example 1
nums1 = [2, 3, 1, 1, 4]
sol1 = Solution()
print("Example 1:", sol1.canJump(nums1))  # Output: True

# Example 2
nums2 = [3, 2, 1, 0, 4]
sol2 = Solution()
print("Example 2:", sol2.canJump(nums2))  # Output: False

# Example 3
nums3 = [0]
sol3 = Solution()
print("Example 3:", sol3.canJump(nums3))  # Output: True

# Example 4
nums4 = [2, 0, 0]
sol4 = Solution()
print("Example 4:", sol4.canJump(nums4))  # Output: True

# Example 5
nums5 = [1, 1, 1, 1, 0, 0]
sol5 = Solution()
print("Example 5:", sol5.canJump(nums5))  # Output: False