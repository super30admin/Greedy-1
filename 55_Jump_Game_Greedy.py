# Time Complexity : O(n) [n = length of input list]
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# 1. Traverse the list in reverse order
# 2. At each step check Can I reach the current index from any of the previous index
# 	2.1 If yes, follow the same steps for corresponding previous index
# 3.If the code flow hits 0 index, return True
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        last_position = len(nums) - 1
        
        for i in range(len(nums) - 1,-1,-1):
            if i+nums[i] >= last_position:
                last_position = i
        return True if last_position == 0 else False