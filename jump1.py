#Time Complexity -- O(n)
#Space Complexity -- O(1)

class Solution:
#     #Explore every possible path
#     def dfs(self, nums, index):
#         if index >= len(nums)-1:
#             return True
        
#         for i in range(1, nums[index]+1):
#             if self.dfs(nums, index+i):
#                 return True
        
#         return False
    
    def canJump(self, nums: List[int]) -> bool:
        
        if not nums:
            return 0
        
        n = len(nums)
        destination = n-1
        
        #Start from destination and check at every point destinaction can be reached. If yes keep updating the destination till you reach beginning of array
        for i in range(n-2, -1, -1):
            if i+nums[i] >= destination:
                destination = i
            
        return destination == 0
        
        
#         if not nums:
#             return
        
#         return self.dfs(nums, 0)

          
        
        
        
