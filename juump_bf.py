"""
Exponential  time

Time Limit Exceeded 
"""
class Solution:
    def jump(self, nums: List[int]) -> int:
        if not nums:
            return 0
        self.mini=float('inf')
        self.dfs(nums,0,0)
        return self.mini
    
    
    def dfs(self,nums,idx,jumps):
        #base
        if(idx>=len(nums)-1):
            self.mini=min(self.mini,jumps)
            return
    
        #logic
        for j in range(1,nums[idx]+1):
            self.dfs(nums,idx+j,jumps+1)
            
        
        
        