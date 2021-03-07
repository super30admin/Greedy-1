class Solution:
    
    """
    Description: Determine ability to reach last index of an array when each element represent max jump length at that position
    
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Approach:
    1. initialize from first index and index equating to maximum reach (say max_i) based on the value 
    2. loop through all items and stop when the current index i matches with the last index in given array to return True
    3. jump max_i to value of max_i or the i + value@i
    """
    
    def canJump(self, nums: List[int]) -> bool:
        
        if nums == None or len(nums) < 2: return True
        
        i = 0; max_i = 0
        while i <= max_i:
            if i == len(nums) - 1: return True
            max_i = max(max_i, i + nums[i])
            i += 1
            
        return False
    
    """
    # DFS Solution:

    def canJump(self, nums: List[int]) -> bool:
        
        if nums == None or len(nums) < 2: return True
        
        return self.dfs(nums, 0)
    
    def dfs(self, nums, idx):
        
        # Base
        if idx >= len(nums) - 1: return True
        
        # Logic
        for j in range(1, nums[idx] + 1):
            if self.dfs(nums, j + idx): return True
        return False
   
    # BFS Solution:

    def canJump(self, nums: List[int]) -> bool:
        
        if nums == None or len(nums) < 2: return True
        
        from collections import deque
        queue = deque()
        queue.append((0, nums[0]))
        
        while queue:
            idx, elem = queue.popleft()
            for j in range(1, elem + 1):
                if j + idx >= len(nums) - 1: return True
                queue.append((j + idx, nums[j + idx]))
                
        return False
    """
