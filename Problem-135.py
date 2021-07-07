'''
Leetcode- 45. Jump Game II - https://leetcode.com/problems/jump-game-ii/
Time complexity - O(N)
space complexity - O(1)
approach - we maintain maxinterval and nextinterval for each iteration and if nums[i]+i >Nextinterval then we update it.

'''
class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums)==0 or len(nums)==1:
            return 0
        Intervalmax=nums[0]
        Nextinterval=nums[0]
        jump=1
        for i in range(1,len(nums)):
            if i+nums[i]>Nextinterval:
                Nextinterval=i+nums[i]
            if Intervalmax==i and i!=len(nums)-1:
                Intervalmax=Nextinterval
                jump+=1
            if Intervalmax>=len(nums)-1:
                 break
        return jump
            
        