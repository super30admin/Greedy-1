class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums:
            return False
        n = len(nums)
        dest = n-1
        for i in range(n-1,-1,-1):
            print (nums[i], i , dest)
            if nums[i] >= dest-i:
                dest = i
            
        if dest <= 0:
            return True
        return False
