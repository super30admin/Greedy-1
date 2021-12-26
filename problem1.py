#Time O(n), space O(1)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        #Starting from last index and see if we are able to reach the first index 
        d=len(nums)-1
        for i in range(len(nums)-2,-1,-1):
            if nums[i]>=d-i:
                d=i
                
        return d==0
