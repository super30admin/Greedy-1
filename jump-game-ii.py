'''

TC: O(n)
SC: O(1)

'''
class Solution:
    def jump(self, nums: List[int]) -> int:
        
        nlen = len(nums)
        
        if nlen <= 1:
            return 0
        
        curr, next = nums[0], nums[0]
        jumps = 1
        
        for i in range(1, nlen):
            if curr >= nlen - 1:
                return jumps
            if i > curr:
                curr = next
                jumps += 1
            if i + nums[i] > next:
                next = i + nums[i]
        
        return jumps
        