# Implemented approach1, approach2, BFS, DFS

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        #Second Approach
        if nums == None or len(nums) < 2: return True
        n = len(nums)
        steps = 1
        for i in range(n -2, -1, -1):
            if nums[i] >= steps:
                steps = 1
            else:
                steps += 1
        return nums[0] >= steps
    
    
# T.C => O(N)
# S.C => O(1)
# Approach =>1.take a variable set if to 1
# 2. start from n -2, if the current index value is less than steps increase the steps by one. 3. if current index value is greater thanor eqaul to steps set it again to 1. 
# 4. at end check and return True if the nums[0] >= steps or else False. 



        
        
        
        
        
        
        
        
        
        
        
        
        
# -----------------------------------------------------------------------------------------        
        
        # First Approach
# -----------------------------------------------------------------------------------
#         if nums == None or len(nums) < 2: return True
#         n = len(nums)
#         destination = n - 1
        
#         for i in range(n-2, -1, -1):
#             if nums[i] + i >= destination:
#                 destination = i
            
#         return destination == 0
# T.C => O(N)
# S.C => O(1)
# Approact=>1. set n and destination. 1. start from n -2 till the 0th index. 
# 2. if the current value + the current index is greater than or equal to destination of i.e from current index can we reach tot the destination then return true, else false
        
        
        
        
# ----------------------------------------------------------------------------------------        
        # BFS Approach
        # if nums == None or len(nums) < 2: return True
        # visited = []
        # q = []
        # q.append(0)
        # visited.append(0)
        # while q:
        #     idx = q.pop(0)
        #     for i in range(1, nums[idx] + 1):
        #         newidx= idx + i
        #         if newidx == len(nums) - 1: return True 
        #         if newidx not in visited:
        #             q.append(newidx)
        #             visited.append(newidx)
        # return False 
                    
# T.C = > Exponential
# S.C => Exponential
# Approach => Still it's slow since we store the index of the visited ones its goes on increasing. until we find the last index. the newly visited index are stored in visited array. we return False if we never found the last index or then return True. Still its very slow and exceeds in python
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    #     def dfs(idx, nums):
    #         if idx in visited: return False
    #         if idx == len(nums) - 1: return True
    #         visited.append(idx)
    #         for i in range(1, nums[idx] + 1):
    #             if dfs(i + idx, nums):
    #                 return True
    #         return False
    #     visited = []
    #     if nums == None or len(nums) < 2: return True
    #     return dfs(0, nums)
    
    
    
    
    # --------------------------------------------------------------------------------------
    # # def dfs(self, idx, nums, visited):
    #     if idx in visited: return False
    #     if idx == len(nums) - 1: return True
    #     visited.append(idx)
    #     for i in range(1, nums[idx] + 1):
    #         if self.dfs(i + idx, nums, visited):
    #             return True
    #     return False
    
# T.C =>Exponential depending on the length of the array
# S.C => exponential, it grows on
# Approach => DFS approach, On every index check the value and appen it to the queue. if we reach the last index its True or else it's False