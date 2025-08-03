from typing import List,collections
# class Solution:
#     def jump(self, nums: List[int]) -> int:
#         n,q,visited,jumps = len(nums), collections.deque([0]), set([0]), 1
#         if n==1: return 0
#         while q:
#             for i in range(len(q)):
#                 curr = q.popleft()
#                 for j in range(1,nums[curr]+1):
#                     newidx = curr+j
#                     if newidx == n-1: return jumps
#                     if newidx not in visited:
#                         q.append(newidx)
#                         visited.add(newidx)
#             jumps+=1
#         return 345432

# class Solution:
#     def jump(self, nums: List[int]) -> int:
#         n,jumps,memo = len(nums),1, {}
#         if n==1: return 0
#         def dfs(nums, idx):
#             # base
#             if idx >= n-1: return 0
#             if idx in memo: return memo[idx]
#             # logic
#             minval = 99999
#             for i in range(1,nums[idx]+1):
#                 curr = idx+i
#                 currmin =  dfs(nums,curr)
#                 minval = min(currmin,minval)
#             memo[idx] = minval +1
#             return minval+1
#         return dfs(nums, 0)

class Solution:
    def jump(self, nums: List[int]) -> int:
        currint = nums[0]
        nextint = nums[0]
        if len(nums) == 1: return 0
        jumps = 1
        for i in range(1, len(nums)):
            nextint = max(nextint, i + nums[i])
            # if i reached the currint reset it to next biggest int
            if i == currint:
                currint = nextint
                if i!=len(nums)-1:
                    jumps+=1
        return jumps


        


        

        