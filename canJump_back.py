"""
Time Complexity O(N)
Space complexity O(1)

"""

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums:
            return False
        n=len(nums)
        destn=n-1
        for i in range(n-2,-1,-1):
            print(i)
            if(i+nums[i]>=destn):
                destn=i
        return destn==0