# https://leetcode.com/problems/jump-game-ii/description/
# BFS

class Solution:
    def jump(self, nums: List[int]) -> int:

        q = deque()
        q.append(0)

        if len(nums) == 1: return 0
        
        n = len(nums)
        level = 0

        visited = set()
        visited.add(0)

        while q:
            size = len(q)
            for i in range(size):
                currIdx = q.popleft()
                for j in range(1, nums[currIdx]+1):
                    newIdx = j + currIdx
                    if newIdx == n - 1: return level+1

                    if newIdx not in visited:
                        visited.add(newIdx)
                        q.append(newIdx)

            level += 1

        return -1

#DFS

class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) == 1: return 0
        self.mini = float('inf')
        self.dfs(nums, 0, 0)
        return self.mini

    def dfs(self, nums, currIdx, steps):

        if currIdx >= len(nums) - 1:
            self.mini = min(self.mini, steps)
            return

        for i in range(1, nums[currIdx]+1):
            newIdx = i + currIdx
            self.dfs(nums, newIdx, steps + 1)

# Recursion with memo

class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) == 1: return 0
        self.memo = [None] * len(nums)
        return self.dfs(nums, 0)

    def dfs(self, nums, currIdx):

        if currIdx >= len(nums) - 1:
            return 0

        if self.memo[currIdx] != None: return self.memo[currIdx]

        mini = 99999

        for i in range(1, nums[currIdx]+1):
            newIdx = i + currIdx
            mini = min(mini, self.dfs(nums, newIdx) +1)

        return mini

# Greedy

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1: return 0
        currInt = nums[0]
        maxInt = nums[0]
        jumps = 1

        for i in range(1, n):
            maxInt = max(maxInt, i + nums[i])

            if i == currInt and i != n-1:
                jumps += 1
                currInt = maxInt

        return jumps