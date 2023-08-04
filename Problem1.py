
'''
Problem: Jump Game
Time Complexity: O(n), where n is given elements
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        Consider initial target to be last index
        if we can reach till target from previous, we change the target
        at the end, if target == 0, we return true   
'''

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        target = n-1

        for i in range(n-2, -1, -1):
            if i + nums[i]>=target:
                target = i
        
        if target == 0:
            return True
        return False
        