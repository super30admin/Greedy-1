#using BFS 
#sc = O(n)
from typing import List
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if(nums==None or len(nums)<2):
            return True

        q= []
        sets = set()
        q.append(0)
        sets.add(0)

        while q:
            idx = q.pop(0)
            for j in range(1, nums[idx]+1):
                newIdx = idx + j
                if(newIdx == len(nums)-1): 
                    return True
                
                if(newIdx not in sets):
                    q.append(newIdx)
                    sets.add(newIdx)
    
        return False

#Using DFS
#sc = O(n)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if(nums==None or len(nums)<2):
            return True
        sets = set()
        return self.dfs(nums, 0, sets)
    
    def dfs(self, nums, idx, sets):
        #base
        if(idx >= len(nums)-1):
            return True

        #logic
        for j in range(1, nums[idx]+1):
            newIdx = idx + j
            if(newIdx in sets):
                continue
            if(self.dfs(nums, newIdx, sets)):
                return True
        
        sets.add(idx)

        return False

#Greedy approach 
# Time Complexity : O(n)
# Space Complexity : O(1)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if(nums==None or len(nums)<2):
            return True
        
        target = len(nums)-1

        for i in range(len(nums)-2, -1, -1):
            if i+nums[i] >= target:
                target = i
        
        return target == 0