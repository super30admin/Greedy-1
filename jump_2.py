#Greedy
""""// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if (n < 2): return 0
        curr = nums[0]
        nexti = nums[0]
        jump = 1

        for i in range(1, len(nums)):
            nexti = max(nexti, i + nums[i])
            if (i != n - 1 and i == curr):
                jump += 1
                curr = nexti
        return jump
    
    def BruteForcejump(self, nums: List[int]) -> int:
        #BFS
        """"// Time Complexity : O(n^2)
        // Space Complexity :O(n)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this :
        """
        n = len(nums)

        q = deque()
        h = set()
        h.add(0)
        q.append(0)
        jump = 0
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if curr >= n - 1:
                    return jump
                for i in range(1, nums[curr] + 1):
                    idx = curr + i
                    if idx not in h:
                        h.add(idx)
                        q.append(idx)
            jump += 1
        return 0
