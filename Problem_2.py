"""
Problem : 2

Time Complexity : 
Approach 1 - O(n!)
Approach 2 & 4 - O(n)

Space Complexity : 
Approach 1 - O(n)
Approach 2 & 4 - O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


"""

# Jump Game II

# Approach - 1
# DFS

class Solution(object):
    def __init__(self):
        self.jumps=float('inf')
    def jump(self, nums):
        if len(nums)<2:
            return 0
        
        self.helper(nums,0,0)
        return self.jumps
    
    def helper(self,nums,idx,jmp):
        if idx>=len(nums)-1:
            self.jumps=min(self.jumps,jmp)
            return
        
        for i in range(1,nums[idx]+1):
            nidx=i+idx
            self.helper(nums,nidx,jmp+1)

# Approach - 2
# BFS

class Solution(object):
    def jump(self, nums):
        if len(nums)<2:
            return 0
        
        dp=[float('inf') for _ in range(len(nums))]
        dp[0]=0
        visited=set()
        q=collections.deque()
        q.append((0,nums[0]))
        visited.add(0)
        while q:
            currIdx,jumps=q.popleft()
            for i in range(currIdx+1,currIdx+jumps+1):
                if i not in visited:
                    visited.add(i)
                    q.append((i,nums[i]))
                    dp[i]=min(dp[i],dp[currIdx]+1)
                    if i==len(nums)-1:
                        return dp[-1]


# Approach - 3
# Memoization

class Solution(object):
    def __init__(self):
        self.memo={}
    def jump(self, nums):
        if len(nums)<2:
            return 0
        return self.dfs(nums,0)
    
    def dfs(self,nums,idx):
        # base
        if idx>=len(nums)-1:
            return 0
        # logic
        minn=float('inf')
        for j in range(1,nums[idx]+1):
            if j+idx<len(nums):
                nidx=j+idx
                if nidx not in self.memo:
                    inter=self.dfs(nums,nidx)
                    self.memo[nidx]=inter
                temp=self.memo[nidx]
                minn=min(temp,minn)
        return minn+1

# Approach - 4
# Greedy

class Solution(object):
    def jump(self, nums):
        if len(nums)<2:
            return 0
        nextInt=nums[0]
        currInt=nums[0]
        jumps=1
        for i in range(1,len(nums)-1):
            nextInt=max(nextInt,i+nums[i])
            if i==currInt:
                currInt=nextInt
                jumps+=1
        return jumps