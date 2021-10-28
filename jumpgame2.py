
#Time Complexity : O(n)
#Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums)==1:
            return 0
        curr = nums[0]
        ne = nums[0]
        jumps = 1
        idx = 0
        while idx<len(nums):
            if idx>curr:
                curr = ne
                jumps += 1
            ne = max(idx+nums[idx], ne)
            idx += 1
        return jumps
    