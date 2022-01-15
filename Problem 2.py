# Time: O(n*n)
# Space: O(n*n) # If we include recursion stack
class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # call
        dp = [-1]*len(nums)
        return self.helper(0, nums, dp)
    def helper(self, i, nums, dp):
        if i >= len(nums) - 1:
            return 0
        if dp[i] != -1:
            return dp[i]
        mn = 1000000007
        for j in range(1, nums[i]+1):
            val = self.helper(i+j, nums, dp)
            mn = min(mn, val)
        dp[i] = 1+mn
        return dp[i]

        

# Time: O(n)
# Space: O(1)
class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return 0
        curr_range = nums[0]
        next_range = nums[0]
        jumps = 1
        for i in range(1, len(nums)):
            if i+nums[i] > next_range:
                next_range = i+nums[i]
            if i == curr_range and i != len(nums)-1:
                jumps += 1
                curr_range = next_range
        return jumps
