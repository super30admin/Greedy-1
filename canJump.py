class Solution:
    def BruteForcecanJump(self, nums: List[int]) -> bool:
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
    
