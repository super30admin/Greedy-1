# Time:- O(n)
# Space:- O(1)
# Approach:- The idea is to minimize the number of jumps so we have to find out the farthest we can jump from at any point. So at index 0 if we have have 2 the farthest we can jump is index 1 or index 2, from index1 the farthest we can jump if it is greater than the farthest we can jump at 
# index2 we should select index1 to be the next point to be explored according to our greedy strategy. 
class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums)<= 1:
            return 0
        l,r=0,nums[0]
        jumps=1
        while r<len(nums)-1:
            jumps+=1
            right=0
            for i in range(l,r+1):
                right=max(right,nums[i]+i)
            l,r=r,right
        return jumps