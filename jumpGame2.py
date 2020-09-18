# Leetcode 45. Jump Game II

# Time Complexity :  O(n) where n is the size of the array

# Space Complexity : O(1)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: In the current window move i through every index to find the best point for next jump i.e.
# the point that can give the maximum jump. Once i reaches the end of current window, increase count of 
# jumps and update current window to the next best location as long as the current has not reached destination.
# When current reaches destination return the number of jumps it took to reach it.

# Your code here along with comments explaining your approach

class Solution:
    def jump(self, nums: List[int]) -> int:
        if not nums or len(nums) < 2:
            return 0
        
        jumps =1
        # pointer for the best jump in current window
        curr = nums[0]
        # pointer for the best jump in next window
        nextt = nums[0]
        
        for i in range(1,len(nums)):
            # move next pointer to the next best jump
            nextt = max(nextt,nums[i]+i)
            # if curr pointer is in bounds and i reaches the best possible jump in current window
            if curr != len(nums)-1 and curr == i :
                # update curr pointer to the location of next best jump and increase counter
                curr = nextt
                jumps += 1
        return jumps