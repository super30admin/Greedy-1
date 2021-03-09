# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def jump(self, nums: List[int]) -> int:
        if not nums or len(nums)<2:
            return 0
        
        jumps = 1 
        curr = nums[0]
        nxt = nums[0]
        for i in range(1,len(nums)):
            nxt = max(nxt, i + nums[i])
            if i < len(nums)-1 and curr == i:
                curr = nxt
                jumps += 1
                
        return jumps