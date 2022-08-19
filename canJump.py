class Solution:
    def __init__(self):
        self.dp = [] 
        
    def TopDowndfs(self, nums, idx):
        if idx >= len(nums)-1: return True
        if  self.dp[idx] != -1:
            return self.dp[idx] == 1 
        for j in range(1, nums[idx]+1):
            result = self.TopDowndfs(nums, idx+j)
            if result:
                self.dp[idx] = 1
                return True
        self.dp[idx] = 0
        return False
	
    def canJump(self, nums: List[int]) -> bool:
        self.dp = [-1]*( len(nums)-1 )
        return self.TopDowndfs(nums, 0)
		
        
    def BruteForceBFScanJump(self, nums: List[int]) -> bool:
        visited = set([])
        visited.add(0)
        q = [] 
        q.append(0)
        while q:
            curr = q.pop(0)
            if curr == len(nums)-1:
                return True
            for i in range(1, nums[curr]+1):
                if curr + i == len(nums)-1:
                    return True
                if curr+i  not in visited:
                    visited.add( curr+i )
                    q.append( curr+i )
        return False
                    
    def BruteForceDFScanJump(self, nums: List[int]) -> bool:
        '''
        Algorithm :
        1. Basic idea is to try all possible jumps for all the elements. 
        2. For each element we try all possible jumps from 1 to the val at the index 
        3. Base condition would be to return True if the index reaches the last index. Otherwise we do not return anything we try to explore the other jumps
        T = O(2^n)
        S = O(1)
        '''
        def dfs(nums, idx):
            if idx == len(nums)-1:
                return True 

            for i in range(1, nums[idx]+1 ):
                if dfs(nums, idx+i):
                    return True
            return False
        
        return dfs(nums, 0)
    
    
    
    
