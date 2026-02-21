class Solution:
    def jump(self, nums: List[int]) -> int:
        dp = [1001]*len(nums)
       

        for i in range(len(nums)-1, -1, -1):
            if i == len(nums)-1:
                dp[i] = 0
                continue
            
            
            dp[i] = 1 + min(dp[i+1: min(i+nums[i], len(nums)-1) + 1]) if len(dp[i+1: min(i+nums[i], len(nums)-1) + 1])>0 else 1001
    
        return dp[0]

        
