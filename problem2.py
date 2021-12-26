#Time O(n*2), space O(n)
class Solution:
    def jump(self, nums: List[int]) -> int:
        dp=[-1]*len(nums)
        
        return self.helper(0,nums,dp)
    
    #Helper function to calculate the steps
    def helper(self,i,nums,dp):
        
        if i >= len(nums)-1:
            return 0
        
        if dp[i]!=-1:
            return dp[i]
 #Calculate the min steps       
        m=float('inf')-1
        for j in range(1,nums[i]+1):
            
            res = self.helper(i+j,nums,dp)  
            m=min(m,res)           
        dp[i]=1+m
                        
        return dp[i]
            
 
