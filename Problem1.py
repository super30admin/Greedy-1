# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#start from end and update the destination according to the point that we can reach for sure
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums == None or len(nums) < 2:
            return True
        
        n = len(nums)
        dest = n-1
        
        for i in range(n-2,-1,-1):
            if nums[i] + i >= dest:
                dest = i
        
        return dest == 0