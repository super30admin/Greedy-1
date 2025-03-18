class Solution:
    # Time = O(n)
    # Space = O(1) 
    def jump(self, nums: List[int]) -> int:
        l = r = 0 
        jumps = 0

        while r < len(nums)-1:
            farthest = 0
            for i in range(l,r+1):
                farthest = max(farthest, i + nums[i])
            l = r + 1
            r = farthest
            jumps += 1
        return jumps