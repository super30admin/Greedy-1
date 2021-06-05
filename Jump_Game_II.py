class Solution:
    def jump(self, nums: List[int]) -> int:
        
        if not nums or len(nums) < 2:
            return 0
        
        n = len(nums)
        jump = 1
        next_jump_value = nums[0]
        current_jum_value = nums[0]
        for i in range(1,n):
            next_jump_value = max(nums[i]+i, next_jump_value)
            
            if current_jum_value == i and i < n-1:
                current_jum_value = next_jump_value
                jump+=1
        
        return jump
            
            
