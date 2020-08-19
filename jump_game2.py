# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. At each step we maximum the next window.
2. start from 0th index, record curr window and next window from each subsequent positions
3. if reaches the curr index , change curr index to next maximum window

'''

import sys
class Solution:
    global_min = 0
    def jump(self, nums: List[int]) -> int:
        
        if not nums or len(nums) < 2:
            return 0
        
        curr = nums[0]
        next_ = nums[0]
        jump_cnt = 1
        
        for i in range(len(nums)):
            next_ = max(next_, nums[i]+i)
            if i < len(nums)-1 and i==curr:
                curr = next_
                jump_cnt += 1
                
        return jump_cnt