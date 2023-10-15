"""
Problem : 1

Time Complexity : 
Approach 1 - O(n)
Approach 2 - O(n!)
Approach 4 - O(n)

Space Complexity :
Approach 1 - O(n)
Approach 2 - O(n)
Approach 4 - O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


"""

# Jump Game

# Approach - 1
# BFS

class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if len(nums)<2:
            return True
        q=collections.deque()
        hset=set()
        q.append(0)
        hset.add(0)

        while q:
            currIdx=q.popleft()
            for j in range(1,nums[currIdx]+1):
                newIdx=currIdx+j
                if newIdx>=len(nums)-1:
                    return True
                if newIdx not in hset:
                    q.append(newIdx)
                    hset.add(newIdx)
        return False
    

# Approach - 2
# DFS

class Solution(object):
    def __init__(self):
        self.flag=False
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if len(nums)<2:
            return True
        
        self.dfs(nums,0)
        return self.flag


    def dfs(self,nums,idx):
        # base
        if self.flag:
            return
        # logic
        for j in range(1,nums[idx]+1):
            nIdx=idx+j
            if nIdx==len(nums)-1:
                self.flag=True
            self.dfs(nums,nIdx)

# Approach - 3
# DP - Memoization

class Solution(object):
    def __init__(self):
        self.memo={}
    def canJump(self, nums):
        if len(nums)<2:
            return True
        
        return self.helper(nums,0)
    
    def helper(self,nums,idx):
        if idx>=len(nums)-1:
            return True
        
        for i in range(nums[idx],0,-1):
            nidx=i+idx
            result=False
            if nidx not in self.memo:
                temp=self.helper(nums,nidx)
                self.memo[nidx]=temp
            result=self.memo[nidx]
            if result:
                return True
        return False
    
# Approach - 4
# Greedy

class Solution(object):
    def canJump(self, nums):
        if len(nums)<2:
            return True
        target=len(nums)-1
        for i in range(len(nums)-2,-1,-1):
            if i+nums[i]>=target:
                target=i
        return target==0