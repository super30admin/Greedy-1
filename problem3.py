class Solution:
    def canJump(self, nums: List[int]) -> bool:

        # dp=[None]*len(nums)
        # dp[-1]=True
        # for i in range(len(nums)-2,-1,-1):
        #     if i+nums[i]>=len(nums)-1:
        #         dp[i]=True
        #     else:
        #         k=nums[i]
        #         flag=False
        #         for j in dp[i:i+k+1]:
        #             if j==True:
        #                 flag=True
        #                 break                
        #         if dp[i+nums[i]]==True or flag :
        #             dp[i]=True
        #         else:
        #             dp[i]=False
        # return dp[0]
        last=len(nums)-1
        for i in range(len(nums)-1,-1,-1):
            if i+nums[i]>=last:
                last=i
        return last==0