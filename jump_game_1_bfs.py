# Time Complexity : O(N^M) where N elements in the array and M is max (jump capacity/strength) number in the array
# Space Complexity : O(N) where N is number of elements in the array. Used for hashset and queue
# Did this code successfully run on Leetcode : No (Time Limit Exceeded)
# Any problem you faced while coding this : No

#BFS Solution
from collections import deque
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        end = len(nums) - 1
        if end == 0: return True
        hashset = set()
        q = deque()
        q.appendleft(0)
        hashset.add(0)
        
        
        while len(q) != 0:
            index = q.pop()
            maxJump = nums[index]
            
            for i in range(1, maxJump + 1):
                nextIndex = index + i
                if nextIndex >= end:
                    return True
                
                if nextIndex not in hashset:
                    q.appendleft(nextIndex)
                    hashset.add(nextIndex)
                    
        return False