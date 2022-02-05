# Greedy-1

## Problem1 Jump Game (https://leetcode.com/problems/jump-game/)
# Time Complexity = O(n)
# Space Complexity=O(1)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        dest=len(nums)-1
        for i in range(len(nums)-1,-1,-1):
            if nums[i]>=dest-i:
                dest=i
        return dest==0       
        
        
           
## Problem2 Jump Game II (https://leetcode.com/problems/jump-game-ii/)
# Time Complexity = O(n)
# Space Complexity=O(1)
class Solution:
    def jump(self, nums: List[int]) -> bool:
        curr=nums[0]
        nex=nums[0]
        jumps=1
        if len(nums)==1:
            return 0
        for i in range(1,len(nums)):
            if nums[i]+i>nex:
                nex=nums[i]+i
            if i==curr and i!=len(nums)-1:
                jumps+=1
                curr=nex
        return jumps
                


## Problem3 Candy (https://leetcode.com/problems/candy/)
# Time Complexity = O(n)
# Space Complexity=O(n)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        candies=[1 for _ in range(len(ratings))]
        for i in range(len(ratings)-1):
            if ratings[i+1]>ratings[i]:
                candies[i+1]=candies[i]+1
        for i in range(len(ratings)-2,-1,-1):
            if ratings[i]>ratings[i+1]:
                candies[i]=max(candies[i],candies[i+1]+1)
        return sum(candies)

