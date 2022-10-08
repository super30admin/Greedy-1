# Optimized BFS
# Time complexity : O(n^k)
# Space complexity : O(n^k)
# Leetcode : Time limit exceeded

from collections import deque
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # if the lenght of the list is less than 2, return True
        if len(nums) < 2:
            return True
        
        # maintain a set to see if we already have a True case from that
        seen = set()
        n = len(nums)
        
        # make a queue and append 0 to it
        q = deque([0])
        
        # add 0 to the set
        seen.add(0)
        
        # traverse until the q is empty
        while q:
          
            # pop the first element from the queue and remove it from the set
            i = q.popleft()
            seen.remove(i)
            
            # we will traverse from the max lenght of index till 0, this way we can eliminate the whole loop
            for j in range(nums[i],0,-1):
                idx = i + j
                
                # if reached to the end, then return True
                if idx >= n-1:
                    return True
                # else add the index to the queue and set
                if idx not in seen:
                    q.append(idx)
                    seen.add(idx)
        
        return False
