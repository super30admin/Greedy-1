#TC:O(n)
#Sc:O(1)
class Solution:
    def jump(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n<=1:
            return 0
        curr_farthest = 0
        jumps=0
        max_jump=0
        for i in range(len(nums)-1):
            max_jump = max(max_jump,i+nums[i])
            if i == curr_farthest:
                curr_farthest = max_jump
                jumps+=1
        return jumps
                
            