# Next Interval approach
# Time Complexity: O(n) n is the length of the array
# Space Complexity: O(1)
class Solution:
    def jump(self, nums: List[int]) -> int:
        if not nums or len(nums) < 2:
            return 0
        
        jumps = 1
        curr = nums[0]
        next_jump = nums[0]
        
        for i in range(1, len(nums)):
            next_jump = max(next_jump, nums[i] + i)
            if i < len(nums) - 1 and i == curr:
                jumps += 1
                curr = next_jump
                
        return jumps