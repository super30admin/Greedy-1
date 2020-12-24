class Solution:
    def canJump(self, nums: List[int]) -> bool:
        dp = [False]*len(nums)
        
        minIndex = len(nums)-1
        dp[-1] = True
        for i in range(len(nums)-2, -1,-1):
            if i+nums[i]>=minIndex:
                minIndex = i
                dp[i] = True
        return dp[0]
    
    
    Time: O(n)
    Space: O(1)
