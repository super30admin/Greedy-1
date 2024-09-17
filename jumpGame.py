# Leetcode 55. Jump Game

# Time Complexity :  O(n) where n is the size of the array

# Space Complexity : O(1)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Starting at the end if the array as destination, if the sum of the current index and the 
# value at current index can reach the destination, then reset destination to current index and move towards
# start of the array. If destination reaches 0th index then return true else false

# Your code here along with comments explaining your approach

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums or len(nums) < 2:
            return True
        
        dest = len(nums)-1
        
        for i in range(len(nums)-2,-1,-1):
            # if the value at current index + index can reach the destination
            if nums[i]+i >= dest:
                # reset dest to the current index
                dest = i
                
        return dest == 0