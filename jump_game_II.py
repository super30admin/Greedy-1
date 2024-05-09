#using BFS
from typing import List
class Solution:
    def jump(self, nums: List[int]) -> int:
        if(nums == None or len(nums)<2):
            return 0
        q = []
        sets= set()
        q.append(0)
        sets.add(0)
        jumps = 0

        while q:
            size = len(q)
            for i in range(0, size):
                currIdx = q.pop(0)
                if(currIdx == len(nums)-1):
                    return jumps
                for j in range(1, nums[currIdx]+1):
                    newIdx = currIdx+j
                    if newIdx not in sets:
                        q.append(newIdx)
                        sets.add(newIdx)
            jumps+=1
        
        return 99

# Time Complexity : O(n)
# Space Complexity : O(1)
class Solution:
    def jump(self, nums: List[int]) -> int:
        if(nums == None or len(nums)<2):
            return 0
        currInt = nums[0]
        nextInt = nums[0]
        jumps = 1

        for i in range(1, len(nums)-1):
            nextInt = max(nextInt, i+nums[i])
            if i == currInt and i != len(nums)-1:
                jumps+=1
                currInt = nextInt
        
        return jumps



        