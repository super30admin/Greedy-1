#Time Complexity : O(n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this : No

from ast import List
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return 0
        
        jumps = 0
        far = 0
        end = 0
        
        for i in range(n - 1):
            far = max(far, i + nums[i])
            if i == end:
                jumps += 1
                end = far
                if end >= n - 1:
                    break
        
        return jumps  
        