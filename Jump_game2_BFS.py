# BFS
# Time complexity : O(n^k)
# Space complexity : O(n^k)
# Leetcode : Time limit exceeded

from collections import deque
class Solution:
    def jump(self, nums: List[int]) -> int:
        
        # if length of the nums list is less than 2, return 0
        n = len(nums)
        jump = 0
        if n < 2:
            return 0
        
        # add the first index to the queue
        q = deque([0])
        
        # traverse until the queue is not empty
        while q:
            # get the size of the queue as we are making node of the minimum jumps
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                # pop the element from the queue and iterate over the indexes that can be reached from the current position
                for i in range(1,nums[curr]+1):
                    idx = i + curr
                    
                    # if reached the end, then return the jumps + 1
                    if idx >= n - 1:
                        return jump + 1
                    # append the other indexes into the queue
                    q.append(idx)
            
            # increment jump after each level
            jump += 1
