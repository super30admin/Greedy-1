'''
TC: O(n)
SC: O(1)
'''
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        nlen = len(nums)
        if nlen == 1:
            return True
        
        dest = nlen - 1
        
        for i in range(nlen - 2, -1, -1):
            if i + nums[i] >= dest:
                dest = i
        
        return dest == 0
        
        