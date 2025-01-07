# // Time Complexity :O(n) for greedy// O(n^2) bfs/dfs
# // Space Complexity :O(1)// O(n) for visited hashset and memoisationMap
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach



#greedy 11ms 
# find maximum interval be
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)

        if n==1: return 0

        currInt = nums[0]
        nextInt = nums[0]
        jumps = 1

        for i in range(n):
            nextInt = max(nextInt, nums[i]+i)
            if i!= n-1 and i == currInt:                # reached end of current interval // dont count jump for last jump(reached end)
                currInt = nextInt
                jumps +=1

            if currInt >= n-1:                          # reached end
                return jumps

        return 0

# Bfs is best solution for level determination // steps needed to reach destination

#bfs with visited  hashset 1607ms
from collections import deque
class Solution:
    def jump(self, nums: list[int]) -> int:
        n = len(nums)

        if n == 1: return 0                                     # edge case
        q = deque()
        q.append(0)

        seen = set()                                            # seen hashset
        seen.add(0)


        level = 0                               
        while q:
            size = len(q)
            for i in range(size):                               # size pop at every level
                currIdx = q.popleft()
                for k in range(1,nums[currIdx]+1):
                    newIdx = currIdx + k
                    if newIdx >= n-1: return level+1            # basecase
                    if newIdx not in seen:                      # if not seen already add 
                        seen.add(newIdx)
                        q.append(newIdx)
            level +=1

        return 0
            
# DFs with memoisation 7608ms :) 
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)

        if n==1: return 0
        memoMap = {}
        
        def dfs(nums,currIdx):
            #basecase
            if currIdx >= n-1:
                return 0
            if currIdx in memoMap: return memoMap[currIdx]
            
            mini = 99999

            #logic
            for i in range(1,nums[currIdx]+1):
                newIdx = currIdx + i
                mini = min(mini, dfs(nums,newIdx)+1 )

            memoMap[currIdx] = mini
            return mini
        return dfs(nums,0)