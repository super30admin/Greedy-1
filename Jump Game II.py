class Solution:
    #Solution 1
    def jump(self, nums: List[int]) -> bool:
        #Approach: Dynamic Programming
        #Time Complexity: O(n^2)
        #Space Complexity: O(n)
        #where, n is the length of nums
        
        n = len(nums)
        
        dp = [0 for _ in range(n)]
        
        for i in range(1, n):
            for j in range(i):
                if (j == 0 or dp[j] != 0) and i - j <= nums[j]:
                    dp[i] = dp[j] + 1
                    break
                    
        print(dp)
        return dp[-1]
    
    #Solution 2
    """
    def jump(self, nums: List[int]) -> int:
        #Approach: Recursion
        #Time Complexity: O(2^n)
        #Space Complexity: O(n)
        #where, n is the length of nums
        
        self.result = inf
        self.helper(nums, 0, 0)
        return self.result
    
    def helper(self, nums, idx, jumps):
        #base
        if idx == len(nums) - 1:
            self.result = min(self.result, jumps)
            return
        if idx >= len(nums):
            return
        
        #logic
        for i in range(1, nums[idx] + 1):
            self.helper(nums, idx + i, jumps + 1)
    """