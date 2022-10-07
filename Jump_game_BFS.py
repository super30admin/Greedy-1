# BFS
# Time complexity : O(n^k)
# Space complexity : O(n^k)
# Leetcode : Time Limited exceeded

from collections import deque
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # if the len of the list is less than 2, return True
        if len(nums) < 2:
            return True
        
        # find the length of the list, make a queue and append the first index to the queue
        n = len(nums)
        q = deque([0])
        
        # traverse until the queue is empty
        while q:
            # pop the first index
            i = q.popleft()
            
            # traverse over all the numbers from 1 till the end
            for j in range(1,nums[i]+1):
                # add the index
                idx = i + j
                
                # check if we have reached the end of the list, if so then return True else we append the index to the queue
                if idx >= n-1:
                    return True
                q.append(idx)
        
        return False
