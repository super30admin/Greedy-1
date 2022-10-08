# DP Solution
# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # if the length of nums list is less than 2, return True
        if len(nums) < 2:
            return True
        
        # find the len of the nums list
        n = len(nums)
        
        # create a dp array of size n and copy the first element to the dp[0]
        dp = nums[0]
        
        # traverse the list from first element till the end
        for i in range(1,n):
            # we check if the previous element has value 0, which means we cannot reach to this index
            # so return False
            if dp == 0:
                return False
            
            # otherwise, find the max of current element in nums and previous index value 
            # in dp - 1(to make the jump)
            dp = max(nums[i],dp-1)
            
        
        # if we reach here, it means that we can reach the end from the starting index
        return True
