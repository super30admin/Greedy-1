# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No


# so instead of starting at the first index 
# we can start from the end of the array and we can shift our target 
# closer to us
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        goal = len(nums) - 1
        for i in range(len(nums)-1, -1, -1):
            if i+nums[i] >= goal:
                goal = i
        return True if goal == 0 else False
        
        