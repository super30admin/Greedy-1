"""
use an exhaustive approach using BFS or DFS. Do BFS to find the path in minimum time. The shortest path will be explored
sooner. Need to use visited to avoid TLE.
TC without visited: k ^n , k: average of the numbers, height of tree = n, number of integers
TC with visited: O(n^2) there is a loop inside the BFS

Todo: DFS + memoization and tabulation

Greedy_approach: start from the end and check if able to reach the end (initial target). If yes, change the target
and keep checking
TC: O(n)
"""

from collections import deque


class Solution_bfs:
    def canJump(self, nums: List[int]) -> bool:

        n = len(nums)
        q = deque()
        visited = [False for _ in range(n)]
        q.append(0)
        visited[0] = True
        while q:
            curr_idx = q.popleft()
            curr_val = nums[curr_idx]
            # check if we reached the end
            if curr_idx >= len(nums) - 1:
                return True

            # starts from 1 since we need to add 1
            for idx in range(1, curr_val + 1):
                newIdx = curr_idx + idx
                if newIdx >= len(nums) - 1:
                    return True
                if newIdx < len(nums) and not visited[newIdx]:
                    visited[newIdx] = True
                    q.append(newIdx)

        return False


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) == 1:
            return True
        n = len(nums)
        target_idx = n - 1

        idx = n - 2
        while idx >= 0:
            # for the current idx where can you jump? curr idx + value at idx
            # it will be the index of the next value
            jump_idx = idx + nums[idx]
            # can I jump from current idx to target
            if jump_idx >= target_idx:
                # change the target
                target_idx = idx

            idx -= 1

        # check with 0, if check with n it is possible the target is changed but 0th index is not reached 
        if target_idx == 0:
            return True
        else:
            return False


