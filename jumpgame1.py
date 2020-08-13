# beginning from position 0, we explore all the paths from the positions reachable from the current.
# We will stop when we reach the end of the array.
# Time complexity - O(n^n)
# Space complexity - O(2n) --we maintain visited array and a stack which can  
# did this code run on leetcode? - No (TLE)
# can also be solved using recursion

from collections import deque

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        if n==1:
            return True
        
        # add the element at nums position 0 in the stack.
        stack = deque([0])
        # visited array
        visited = [False for _ in range(n)] 
        
        while stack:
            top = stack.pop()
            
            # beginpos = min(n-1, nums[top])-top
            
            for i in range(min(n-1,nums[top])-top, -1, -1):
                if top+i == n-1: return True # if it reaches the end.
                # check if the node is not already processed.
                if not visited[top+i]:
                    visited[top+i] = True
                    stack.append(top+i)
            
        return False # if the last position is not reachable.
        
        
# set the destination to the last index of array
# begin traversing from the second last index to the first.
# if the destination is reachable from the new index, set the destination to this index.
# Time complexity - O(n)
# Space complexity - O(1)
# Does this code run on leetcode? - yes
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)

        destination = n-1 
        for i in range(n-2, -1, -1):
            if destination <= nums[i] + i:
                destination = i  # update the destination if the old destination is reachable from the current index.
        return destination == 0

    
# beginning from the top.
# check what is the max reachable node from the beginning of the array
# return True, if it can reach the end. 
# Time complexity - O(n)
# Space complexity - O(1)
# Does this code run on leetcode? - yes
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        
        maxreachable = nums[0] 
        for i in range(1, n):
            if maxreachable >= i:
                maxreachable = max(maxreachable, i+nums[i])
        
        return maxreachable >= n-1

        