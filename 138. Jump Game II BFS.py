from collections import deque

class Solution:
    def jump(self, nums: List[int]) -> int:
        if nums is None or len(nums) < 2:
            return 0
        visited = set()
        q = deque()
        q.append(0)
        visited.add(0)
        jumps = 0

        while len(q) > 0:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if curr >= len(nums) - 1:
                    return jumps
                for jump in range(1, nums[curr] + 1):
                    if curr + jump not in visited:
                        q.append(curr + jump)
                        if curr >= len(nums) - 1:
                            return jumps
                        visited.add(curr + jump)

            jumps += 1
        return 1234567

# BFS
# Time Complexity: O(2^n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
