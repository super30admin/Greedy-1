
#--------Solution 1 : DFS : recursive : Timelimit exceed-------
''' Time Complexity : O(2^k) : k is average no of jumps
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : No
    Any problem you faced while coding this :  No
'''
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        sett = set()
        def helper(pivot, nums):
            #base
            if pivot == (len(nums)-1):
                return True
            if pivot in sett:
                return False
            #logic
            for i in range(1, nums[pivot]+1 ):
                newidx = pivot + i
                if helper(newidx, nums): return True
            
            sett.add(pivot)
            return False
        
        return helper(0,nums)

#--------Solution 2 : BFS -------
''' Time Complexity : O(2^k) : k is average no of jumps
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        if n == 1:
            return True
        sett = set()
        q = deque()
        target = n-1
        q.append(0)
        sett.add(0)
        while q:
            idx = q.pop()
            for i in range(1,nums[idx]+1):
                newidx = idx + i
                if newidx == target:
                    return True
                if newidx not in sett:
                    q.append(newidx)
                    sett.add(idx)
        return False
    
#--------Solution 3 : Updating the target from backward -------
''' Time Complexity : O(n) : k is average no of jumps
    Space Complexity : O(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        target = n-1
        for i in range(n-2,-1,-1):
            if i + nums[i] >= target:
                target = i
        
        if target == 0:
            return True
        else:
            return False
    

            
