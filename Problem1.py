# Problem 1: Jump Game
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        if n == 1: return True
        q = deque()
        visited = set()
        q.append(0)
        visited.add(0)

        while q:
            currIdx = q.popleft()
            for j in range(1,nums[currIdx]+1):
                newIdx = currIdx + j
                if newIdx >= n-1: return True
                if newIdx not in visited:
                    q.append(newIdx)
                    visited.add(newIdx)

        return False
        