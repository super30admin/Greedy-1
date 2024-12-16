# Approach1: BFS
# Approach2: DFS
# Approach3: DP
# Approach4: Greedy

# BFS with Memoization; Time: O(N) Space:O(N)
# class Solution:
#     def jump(self, nums: List[int]) -> int:
#         q = deque([0])
#         visited = set([0])
#         min_jumps = float('inf')
#         level = 0

#         if len(nums) == 1:
#             return 0
#         while q:
#             level += 1
#             for _ in range(len(q)):
#                 index = q.popleft()
#                 for jump in range(1, nums[index]+ 1):
#                     next_index = jump + index

#                     if next_index >= (len(nums) - 1):
#                         min_jumps = min(min_jumps, level)

#                     if next_index < len(nums) and next_index not in visited:
#                         q.append(next_index)
#                         visited.add(next_index)
#         return min_jumps

# DFS with Memoization; Time: O(N2) Space:O(N)
# class Solution:
#     def jump(self, nums: List[int]) -> int:
#         def dfs(index):
#             # Base Case
#             if index >= len(nums) - 1:
#                 return 0

#             if index in memo:
#                 return memo[index]

#             min_jumps = float('inf')
#             # Recurse
#             for jump in range(1, nums[index] + 1):
#                 next_index = index + jump
#                 min_jumps = min(min_jumps, 1 + dfs(next_index))

#             memo[index] = min_jumps
#             return min_jumps

#         memo = {}
#         return dfs(0)

# DP Solution; Time: O(N2) Space:O(N)
# class Solution:
#     def jump(self, nums: List[int]) -> int:
#         n = len(nums)
#         dp = [float('inf')] * n
#         dp[0] = 0

#         for i in range(1,n):
#             for j in range(i):
#                 if j + nums[j] >= i:
#                     dp[i] = min(dp[i], 1 + dp[j])
#         return dp[-1]

# Greedy; Time: O(N) Space:O(1)
# Optimzed: Simliar to BFS but with space O(1)
class Solution:
    def jump(self, nums: List[int]) -> int:
        farthest = 0
        l, r = 0, 0
        jumps = 0
        while r < len(nums) - 1:
            for i in range(l, r + 1):
                farthest = max(farthest, i + nums[i])
            l = r + 1
            r = farthest
            jumps += 1
        return jumps


