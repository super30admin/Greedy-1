class Solution:
    def jump(self, nums: List[int]) -> int:
        position = nums[0]
        if len(nums) == 1:
            return 0
        steps = nums[0]]
        jump = 1
        for i in range(1, len(nums)):
            if i>steps:
                jump+=1
                steps = position
            position = max(position, i+nums[i])
        return jump
    
# CurrMax Max Index Without Jump = Position
# If CurrMax without Jump< index, then we jump and update the current max position to the maxStepPosition
Time : O(N)
Space: O(1)

    
