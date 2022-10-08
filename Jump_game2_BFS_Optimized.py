# Optimized BFS
# Time complexity : O(n^k)
# Space complexity : O(n^k)
# Leetcode : Solved and submitted

from collections import deque
class Solution:
    def jump(self, nums: List[int]) -> int:
        
        # if length of the nums list is less than 2, return 0
        n = len(nums)
        jump = 0
        
        # maintain a set to check for the same indexes
        seen = set()
        
        if n < 2:
            return 0
        
        # add the first index to the queue
        q = deque([0])
        seen.add(0)
        
        # traverse until the queue is not empty
        while q:
            # get the size of the queue as we are making node of the minimum jumps
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                seen.remove(curr)
                # pop the element from the queue and iterate over the indexes that can be reached from the current position
                for i in range(nums[curr],0,-1):
                    idx = i + curr
                    
                    # if reached the end, then return the jumps + 1
                    if idx >= n - 1:
                        return jump + 1
                    # append the other indexes into the queue if they are not present in the set
                    if idx not in seen:
                        q.append(idx)
                        seen.add(idx)
            
            # increment jump after each level
            jump += 1
