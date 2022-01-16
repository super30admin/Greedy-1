# Brute-Force Using BFS
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums == None or len(nums) < 2:
            return True
        q = deque()
        visited = set()
        q.append(0)
        visited.add(0)
        while q:
            curr = q.popleft()
            value = nums[curr]
            for i in range(1, value+1):
                newIdx = curr + i
                if newIdx  == len(nums) -1:
                        return True
                if newIdx not in visited:
                    q.append(newIdx)
                    visited.add(newIdx)
        return False

# Brute-Force Using DFS
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums == None or len(nums) < 2:
            return True
        self.visited = set()
        return self.dfs(0, nums)
    
    def dfs(self, idx, nums):
        if idx in self.visited:
            return False
        if idx == len(nums)-1:
            return True
        
        self.visited.add(idx)
        for i in range(1, nums[idx] + 1):
            if self.dfs(idx + i, nums):
                return True
            
        return False

# Time Complexity: O(n^n)
# Space Complexiy: O(n)

# Greedy Solution
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums == None or len(nums) < 2:
            return True
        dest = len(nums) - 1
        
        for i in range(len(nums) -2, -1, -1):
            if nums[i] + i >= dest:
                dest = i
        return dest == 0

# Time Complexity: O(n)
# Space Complexiy: O(1)
