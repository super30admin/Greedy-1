from collections import deque

class Solution:
    #Solution 1
    def jump(self, nums: List[int]) -> bool:
        #Approach: BFS
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        #where, n is the length of nums
        
        if len(nums) <= 1:
            return 0
        
        jumps = 1
        currLast = nums[0]
        nextLast = nums[0]
        
        if currLast == len(nums) - 1:
            return jumps
        
        for i in range(1, len(nums)):
            nextLast = max(nextLast, i + nums[i])
            
            if currLast == i:
                jumps += 1
                currLast = nextLast
                
            if currLast >= len(nums) - 1:
                break
            
        return jumps
    
    #Solution 2
    """
    def jump(self, nums: List[int]) -> bool:
        #Approach: BFS
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        #where, n is the length of nums
        
        de = deque()
        visited = set()
        
        de.append(0)
        visited.add(0)
        
        jumps = 0
        while de:
            sz = len(de)
            for _ in range(sz):
                idx = de.popleft()
                if idx == len(nums) - 1:
                    return jumps
                
                for j in range(1, nums[idx] + 1):
                    if idx + j not in visited:
                        de.append(idx + j)
                        visited.add(idx + j)
            
            jumps += 1
            
        return -1
    """
    
    #Solution 3
    """
    def jump(self, nums: List[int]) -> bool:
        #Approach: Dynamic Programming
        #Time Complexity: O(n^2)
        #Space Complexity: O(n)
        #where, n is the length of nums
        
        n = len(nums)
        
        dp = [inf for _ in range(n)]
        dp[0] = 0
        
        for i in range(1, n):
            for j in range(i):
                if (j == 0 or dp[j] != 0) and i - j <= nums[j]:
                    dp[i] = dp[j] + 1
                    break
                    
        return dp[-1]
    """
    
    #Solution 4
    """
    def jump(self, nums: List[int]) -> int:
        #Approach: Recursion // dfs
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