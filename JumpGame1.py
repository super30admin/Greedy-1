# Time Complexity : O(n) 
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    def canJump(self, nums):
        if len(nums) < 2:
            return True 
        destination = len(nums)-1
        
        for i in range(len(nums)-2, -1, -1):
            if nums[i] + i >= destination:
                destination = i 
            
        if destination == 0:
            return True 
        return False 

# Time = O(n^n) | Space = O(n^n)     
# DFS approach, Time limit exceeded. Here we explore all the paths.
# 1) Jump has to be from 1.
# 2) destination is len(nums)-1

# class Solution:
#     def canJump(self, nums: List[int]) -> bool:
#         if len(nums) < 2:
#             return True 
#         return self.dfs(nums, 0)
    
#     def dfs(self, nums, i):
#         # base case 
#         if i == len(nums)-1:
#             return True 
#         # logic 
#         for j in range(1, nums[i]+1):
#             if(self.dfs(nums, i+j)):
#                 return True 
        
#         return False


if __name__ == "__main__":
    s = Solution()
    print(s.canJump([2,3,1,1,4])) 