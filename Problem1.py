# Approach1: BFS
# Approach2: DFS
# Approach3: Greedy

# BFS with Memoization; Time: O(N) Space:O(N)
# class Solution:
#     def canJump(self, nums: List[int]) -> bool:
#         visited = set([0])
#         q = deque([])
#         q.append(0)

#         if len(nums) == 1:
#             return True

#         while q:
#             index = q.popleft()
#             # Check all possible jumps from the current index
#             for jump in range(1, nums[index] + 1):
#                 next_index = jump + index
#                 # Reached or exceeded the last index
#                 if next_index >= (len(nums) - 1):
#                     return True
#                 if next_index not in visited:
#                     q.append(next_index)
#                     visited.add(next_index)

#         return False


# DFS with Memoization; Time: O(N) Space:O(N)
# class Solution:
#     def canJump(self, nums: List[int]) -> bool:
#         memo = set()

#         def dfs(index):
#             # Base Case
#             if index >= len(nums) - 1:
#                 return True

#             if index in memo:
#                 return False

#             # Recurse
#             for jump in range(1, nums[index] + 1):
#                 next_index = index + jump
#                 if dfs(next_index):
#                     return True
#             memo.add(index)
#             return False

#         return dfs(0)


# Greedy; Time: O(N) Space:O(N)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        position = len(nums) - 1

        for i in range(len(nums) - 2, -1, -1):
            if i + nums[i] >= position:
                position = i

        return position == 0
