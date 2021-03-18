'''
T = O(n)
S = O(n)

Approach:
Apply dfs from the first node to last possible node,
Stop at untill the index reaches more than the lenght of the nums.
'''
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums:
            return False
        
        return self.dfssolution(nums,0)
        
    def dfssolution(self,nums,index):
        if index >= len(nums)-1:
            return True
        
        for i in range(1,nums[index]+1):
            if self.dfssolution(nums,index+i) == True:
                return True
        return False

'''
T = O(n)
S = O(n)

Approach:
Apply BFS
'''
from collections import deque
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums:
            return False
        Q = deque()
        Q.append(0)
        
        while Q:
            curr = Q.pop()
            if curr == len(nums)-1:
                return True
            for i in range(curr+1,curr+nums[curr]+1):
                if i >= len(nums):
                    return True
                Q.append(i)
        return False

'''
T = O(n)
S = O(n)

Approach:
Traverse from Resverse and update the destination for every coorect jump
'''
from collections import deque
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums:
            return False
        dst = len(nums)-1
        for i in range(len(nums)-2,-1,-1):
            if nums[i] + i >= dst:
                dst = i
        if dst == 0:
            return True
        return False
            