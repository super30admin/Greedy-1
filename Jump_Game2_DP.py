
# DP
# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def jump(self, nums: List[int]) -> int:
        # return 0 if the length of the list is less than 2
        if len(nums) < 2:
            return 0
        
        # create a dp array same as the length of the nums list
        dp = [0 for _ in range(len(nums))]
        # copy the first element of the list to the dp array
        dp[0] = nums[0]
        
        # traverse over the list
        for i in range(1,len(nums)-1):
            # update the dp as the max of prev element -1 and the current index value in nums list
            dp[i] = max(dp[i-1]-1,nums[i])
        
        # now we will find the jumps
        idx = jump = 0
        # traverse over the dp array and jump from the index and see if we reach the last index
        while idx < len(nums) - 1:
            idx += dp[idx]
            jump += 1
        
        return jump
