# Time Complexity : O(n)
# Space Complexity : O(1)
class Solution:
    def jump(self, nums):
        if not nums:
            return 0
        
        count, currentEnd, jump, n = 0, 0, 0, len(nums)
        
        for i in range(n - 1):  # Pointer 1 - goes through the array till the second last element.  No jump
                                # needed from the last element
            jump = max(jump, i + nums[i])  # Max possible jump for each element
            if i == currentEnd:  # If we reached the current end we have already jumped to, then we need to
                                 # jump again.
                count += 1  # Update count as we are jumping again
                currentEnd = jump  # Pointer two - keeps track of how far we have jumped till now.  Is updated
                                   # as soon as pointer 1 reaches it.
                if currentEnd >= n - 1:  # If current end exceeds the array limit or reaches the last element, stop.
                    break
        
        return count

# Examples and Analysis

# Example 1
nums1 = [2, 3, 1, 1, 4]
sol1 = Solution()
print("Example 1:", sol1.jump(nums1))  # Output: 2

# Example 2
nums2 = [2, 3, 0, 1, 4]
sol2 = Solution()
print("Example 2:", sol2.jump(nums2))  # Output: 2

# Example 3
nums3 = [1, 2, 1, 1, 1]
sol3 = Solution()
print("Example 3:", sol3.jump(nums3))  # Output: 3

# Example 4
nums4 = [1, 1, 1, 1, 1]
sol4 = Solution()
print("Example 4:", sol4.jump(nums4))  # Output: 4

# Example 5
nums5 = [2, 1]
sol5 = Solution()
print("Example 5:", sol5.jump(nums5))  # Output: 1