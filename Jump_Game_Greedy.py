# Greedy Approach
# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def canJump(self, nums: List[int]) -> bool:
      
        # find the length of the array and make target as the last index
        n = len(nums)
        target = n-1
        
        # start from the last index until we reach the first index
        for i in range(n-2,-1,-1):
          
            # add the current index with the value at current index and check if it is greater than the target, if so then make the new target as i
            if i + nums[i] >= target:
                target = i
        
        # at the end, if target is 0, then we can reach the end from the start, so return True else False
        if target == 0:
            return True
        return False
