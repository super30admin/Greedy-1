"""
Time Complexity: O(n)
    - We traverse the array once from right to left.

Space Complexity: O(1)
    - Only constant extra variables are used.

Approach:
    - Use a greedy backward strategy.
    - Start from the second-last index and track the closest index (`reach`)
        that can reach the end.
    - For each index `i`, check whether nums[i] can jump far enough to reach
        the current `reach`. If so, update `reach` to `i`.
    - If after processing all indices, `reach` becomes 0, the start can reach
        the end.
"""
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        reach = n - 1

        for i in range(n-2, -1, -1):
            max_jump = nums[i]
            need = reach - i
            if max_jump >= need:
                reach = i
        
        return reach == 0