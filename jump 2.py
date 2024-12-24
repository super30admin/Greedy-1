"""
Todo: DFS + memoization and tabulation
Greedy_approach: greedy on the intervals not on the jumps. Maintain a max_interval.
 0  1 2 3 4 5 6 7 8 9 10 11
[2,3,1,4,3,1,2,0,1,3,1, 2]


    number of jumps                  current interval (idx)                         max_interval
        1 (can reach 3 and 1)               2 (from ith idx                             2nd idx (difference between
        from the 3 and 1,which                  where can you reach)                      ith index and max reach)
        jump will help maximize the
        interval
        1 (from 3)                                2                                         max(2,4) = 4th idx
        1  (from 1)                               2                                         max(4,3) = 4th idx
        # till here moving in the same
        # interval
        2 (to reach 3rd idx should
        have taken any of the jumpss)
"""

from collections import deque
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return 0

        q = deque()
        visited = set()
        q.append(0)
        visited.add(0)
        jump = 0

        while q:
            size = len(q)
            for _ in range(size):
                curr_idx = q.popleft()
                # start from 1 and incldue the current idx as well
                for idx in range(1, nums[curr_idx]+1):
                    newIdx = curr_idx + idx
                    if newIdx >= n-1:
                        return jump+1
                    if newIdx not in visited:
                        visited.add(newIdx)
                        q.append(newIdx)

            jump += 1






