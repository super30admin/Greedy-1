# // Time Complexity :O(n) for greedy, O(n^2) for bfs and dfs
# // Space Complexity :O(1) for greedy //memoisation : O(n) hashset
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :Using DFS always gave time limit exeeded start to finish, not the other way around.


# // Your code here along with comments explaining your approach
# We iterate from the end and find if destination can be reached.

# greedy solution
class Solution:
    def canJump(self, nums: list[int]) -> bool:
        n = len(nums)
        target = n-1

        for i in range(n-2,-1,-1):              # in reverse
            if nums[i] + i >= target:           # currentNum + currIndex sum should be greaterThanOrEqualTo the destination.
                target = i                      # current passes? make it the new destination
            
        return target == 0
    
a = Solution().canJump([2,3,1,1,4])
b = Solution().canJump([3,2,1,0,4])
print(a,b)


#dfs 5153ms :)
class Solution:
    def canJump(self, nums: list[int]) -> bool:
        n = len(nums)
        if n == 1: return True
        memo = set()
        
        def dfs(nums, currIdx):

            #basecase
            if currIdx >= len(nums)-1: return True
            if currIdx in memo: return False                # already explored

            #logic
            for i in range(nums[currIdx], 0,-1):            # n-1 to 0 gives 5k ms// 0-n-1 doesnt work on python 
                newIdx = currIdx + i
                if dfs(nums,newIdx):
                    return True
            memo.add(currIdx)                               # memoise
            return False

        return dfs(nums,0)



# bfs 2543ms 
from collections import deque

class Solution:
    def canJump(self, nums: list[int]) -> bool:
        n = len(nums)
        if n==1: return True                # edge case

        q = deque() 
        q.append(0)

        seen = set()
        seen.add(0)

        while q:
            currIdx = q.popleft()
            for i in range(1,nums[currIdx]+1):
                newIdx = currIdx + i
                if newIdx >= n-1: return True                   # basecase
                if newIdx not in seen:                          # visited map
                    q.append(newIdx)
                    seen.add(newIdx)
        return False
