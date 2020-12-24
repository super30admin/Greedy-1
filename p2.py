#Time: O(N)
#Space: O(1)
class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums)==0  or len(nums)==1:
            return 0
        cur_int = nums[0]
        next_int = nums[0]
        jumps = 1
        n = len(nums)
        for i in range(1,n):
            next_int = max(next_int,nums[i]+i)
            if i < n-1 and i == cur_int:
                cur_int = next_int
                jumps+=1
        
        return jumps
                
                
                
            
        
        
