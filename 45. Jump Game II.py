'''
T =O(n)
S = O(1)

Approach:
At every interval find the best interval that is for the next interval and make the jumps accordingly
'''


class Solution:
    def jump(self, nums: List[int]) -> int:
        if not nums or len(nums) == 1:
            return 0
        jumps = 1
        CurrInt = nums[0]
        NextInt = nums[0]
        for i in range(1,len(nums)):
            NextInt = max(NextInt,i+nums[i])
            if i < len(nums)-1 and CurrInt == i:
                jumps += 1
                CurrInt = NextInt
        return jumps

'''
T =O(n!)
S = O(1)

Approach:
Perform dfs to find all the possible routes and at each route store the jumps comparing the previous min jumps
'''           
class Solution:
    def __init__(self):
        self.MinJumps = float('inf')
        
    def jump(self, nums: List[int]) -> int:
        if nums == None or len(nums) < 2:
            return 0
        self.dfs(nums,0,0)
        return self.MinJumps
    
    def dfs(self,nums,index,jumps):
        if index >= len(nums) - 1:
            self.MinJumps = min(jumps,self.MinJumps)
            return
        for i in range(1,nums[index]+1):
            self.dfs(nums, index + i , jumps + 1)
            
'''
T =O(n!)
S = O(1)

Approach:
Perform bfs at every level increase the jump by 1
''' 
from collections import deque
class Solution:
    def jump(self, nums: List[int]) -> int:
        if nums == None or len(nums) < 2:
            return 0
        visited = set()
        Q = deque()
        Q.append(0)
        visited.add(0)
        jumps = 0
        while Q:
            size = len(Q)
            for i in range(size):
                idx = Q.pop()
                if idx >= len(nums)-1:
                    return jumps
                for j in range(1,nums[idx]+1):
                    if idx+j not in visited:
                        Q.append(idx+j)
                        visited.add(idx+j)
            jumps += 1