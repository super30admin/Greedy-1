# https://leetcode.com/problems/jump-game/description/

# BFS solution
# TC: K^n
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        if len(nums) == 1: return True
        q = deque()
        q.append(0)

        while q:
            currIdx = q.popleft()

            for i in range(1, nums[currIdx]+1):
                newIdx = currIdx + i
                if newIdx == len(nums) - 1:
                    return True

                q.append(newIdx)

        return False
    
# BFS with visited 
# TC: O(n^2)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        if len(nums) == 1: return True
        q = deque()
        q.append(0)

        visited = set()
        visited.add(0)

        while q:
            currIdx = q.popleft()

            for i in range(1, nums[currIdx]+1):
                newIdx = currIdx + i
                if newIdx == len(nums) - 1:
                    return True

                if newIdx not in visited:
                    q.append(newIdx)
                    visited.add(newIdx)

        return False
    
# dfs
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        self.memoSet = set()
        if len(nums) == 1: return True
        
        return self.dfs(nums, 0)

    def dfs(self, nums, currIdx):
        if currIdx == len(nums) - 1: return True
        if currIdx in self.memoSet: return False

        for i in range(1, nums[currIdx]+1):
            newIdx = currIdx + i
            if self.dfs(nums, newIdx): return True

        self.memoSet.add(currIdx)
        return False

# DP
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        dp = [False] * n

        dp[n-1] = True

        for i in range(n-2, -1, -1):
            farthestJump = min(n-1, i + nums[i])
            for j in range(i+1, farthestJump+1):
                if dp[j]:
                    dp[i] = True
                    break

        return dp[0]

# Greedy
# TC: O(n)
# We are traversing the nums array backwards. Initialize target as last index in nums array
# We try to see if we can reach the target from my current index. If so, then update the target to my current index
# Do this until target becomes 0 (i.e., we are saying we can reach the target if we were able to update target until 0)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        target = n-1

        for i in range(n-2, -1, -1):
            if i + nums[i] >= target:
                target = i

        return target == 0