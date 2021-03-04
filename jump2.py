#Time Complexity -- O(n)
#Space Complexity -- O(1)

class Solution:
    
#     #Explore every possible path
#     def dfs(self, nums, index, jumps):
#         if index >= len(nums)-1:
#             self.minjumps = min(self.minjumps, jumps)
#             return
        
#         for i in range(1, nums[index]+1):
#             self.dfs(nums, index+i, jumps+1)

    
    
    def jump(self, nums: List[int]) -> int:
        
        
        if not nums or len(nums)<2:
            return 0
        
        n = len(nums)
        currInd = nums[0]
        nextInd = nums[0]
        jumps = 1
        
        for i in range(1, n):
            nextInd = max(nextInd, nums[i]+i)
            if i < n-1 and currInd == i:
                currInd = nextInd
                jumps += 1
                
        
        return jumps
                
            
        
        
        
#         if not nums:
#             return
        
#         self.minjumps = float("inf")
#         self.dfs(nums, 0, 0)
#         return self.minjumps
        
