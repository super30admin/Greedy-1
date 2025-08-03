from typing import List,collections
# class Solution:
#     def canJump(self, nums: List[int]) -> bool:
#         q,visited,n = collections.deque([0]), set(), len(nums)
#         if n == 1:
#             return True
#         visited.add(0)
#         while q:
#             curr = q.popleft()
#             for i in range(1,nums[curr]+1):
#                 newidx = curr + i
#                 if newidx == n-1: return True
#                 if newidx not in visited:
#                     q.append(newidx)
#                     visited.add(newidx)
#         return False

# class Solution:
#     def canJump(self, nums: List[int]) -> bool:
#         n = len(nums)
#         if n == 1:
#             return True
#         memo = {}
#         def dfs(nums, idx):
#             # base
#             if idx == n-1: return True
#             if idx in memo : return memo[idx]

#             # logic 
#             for i in range(1,nums[idx]+1):
#                 newidx = idx+i
#                 if dfs(nums,newidx):
#                     memo[idx] = True
#                     return True
#             memo[idx] = False
#             return False
#         return dfs(nums, 0)
# class Solution:
#     def canJump(self, nums: List[int]) -> bool:
#         n = len(nums)
#         if n == 1:
#             return True
#         memo = set()
#         def dfs(nums, idx):
#             # base
#             if idx == n-1: return True
#             if idx in memo : return False

#             # logic 
#             for i in range(1,nums[idx]+1):
#                 newidx = idx+i
#                 if dfs(nums,newidx):
#                     return True
#             memo.add(idx)
#             return False
#         return dfs(nums, 0)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        target = n-1
        for i in range(n-2,-1,-1):
            if i+nums[i] >= target:
                target = i
        return target == 0
            

        

        
            

        

        