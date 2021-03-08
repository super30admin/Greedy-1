# Approach - Maintain two intervals and whenever current index (i) == current interval then we update the interval and increment jump, if it exceeds total numbers, break there
# Time - O(N)

# Space - O(1)

class Solution:
    def jump(self, nums: List[int]) -> int:
        if not nums or len(nums) < 2:
            return 0
        
        currInterval = nums[0]
        nextInterval = nums[0]
        jumps = 1
        
        for i in range(1, len(nums)-1):
            if nums[i]+i > nextInterval:
                nextInterval = nums[i]+i
                
            if i == currInterval:
                currInterval = nextInterval
                jumps += 1
                
            if currInterval >= len(nums)-1:
                break
        
        return jumps