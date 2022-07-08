'''
BFS
Time: O(n)
Space: O(n), for set and deque
'''

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        if len(nums) == 1:
            return True
        
        hs = set()
        q = collections.deque()
        q.append(0)
        
        level = 0
        while len(q) != 0:
            size = len(q)
            for i in range(size):
                curr = q.popleft() 
                if curr == len(nums) - 1:
                    return True
                for j in range(1,nums[curr]+1):
                    if curr + j not in hs:
                        q.append(curr + j)
                        hs.add(curr + j)
                    
            level += 1
            
        return False
        


'''
DFS (void)
Time: O(n)
Space: O(n),for set and recursive stack
'''

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        self.res = False
        self.hs = set()
        self.dfs(nums, n, 0)
        return self.res

    
    def dfs(self, nums, n, index):
        # base
        if index >= n - 1:
            self.res = True
            return
        
        self.hs.add(index)
        
        # logic
        for i in range(1,nums[index]+1):
            if index + i not in self.hs:
                self.dfs(nums, n, index + i)
            
            
 '''
DFS (bool)
Time: O(n)
Space: O(n), for set and recursive stack
'''

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        self.hs = set()
        return self.dfs(nums, n, 0)


    
    def dfs(self, nums, n, index):
        # base
        if index >= n - 1:
            return True
        
        self.hs.add(index)
        
        # logic
        for i in range(1,nums[index]+1):
            if index + i not in self.hs and self.dfs(nums, n, index + i):
                return True
        
        return False


'''
Greedy Efficient
Time: O(n)
Space: O(1)
'''

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        if len(nums) == 1:
            return True
        
        target = len(nums) - 1
        i = len(nums) - 2
        
        while i >= 0:
            if nums[i] + i >= target:
                target = i
            i -= 1
        
        if target == 0:
            return True
        else:
            return False

