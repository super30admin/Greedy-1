"""
Time complexity O(N)
Space complexity O(1)


"""

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums:
            return False
        n=len(nums)
        reach=0
        for i in range(n):
            if(i>reach):
                return False
            reach=max(reach,i+nums[i])
        return True
            
        