class Solution:
    def canJump(self, nums: List[int]) -> bool:
        currWindow = 0
        n = len(nums)
        
        for i in range(n):
            if currWindow < i:
                return False

            currWindow = max(currWindow, i + nums[i])
        return True