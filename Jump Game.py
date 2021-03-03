class Solution:
    #Solution 1
    def canJump(self, nums: List[int]) -> bool:
        #Approach: Greedy
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        #where, n is the length of nums
        
        idx = 0     #the last index we can surely reach
        
        for i in range(len(nums)):
            if idx < i:
                return False
            idx = max(idx, i + nums[i])
            if idx >= len(nums) - 1:
                return True
    
    #Solution 2
    """
    def canJump(self, nums: List[int]) -> bool:
        #Approach: Dynamic Programming
        #Time Complexity: O(n^2)
        #Space Complexity: O(n)
        #where, n is the length of nums
        
        n = len(nums)
        
        dp = [False for _ in range(n)]
        dp[0] = True
        
        for i in range(1, n):
            for j in reversed(range(i)):
                if dp[j] == True and i - j <= nums[j]:
                    dp[i] = True
                    break
                    
        return dp[-1]
    """
    
    #Solution 3
    """
    def canJump(self, nums: List[int]) -> bool:
        #Approach: Recursion
        #Time Complexity: O(2^n)
        #Space Complexity: O(n)
        #where, n is the length of nums
        
        self.result = False
        self.helper(nums, 0)
        return self.result
    
    def helper(self, nums, idx):
        #base
        if idx == len(nums) - 1:
            self.result = True
            return
        if self.result or idx >= len(nums):
            return
        
        #logic
        for i in range(1, nums[idx] + 1):
            self.helper(nums, idx + i)
    """