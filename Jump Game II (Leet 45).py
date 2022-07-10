'''
BFS
Time: O(n)
Space: O(n)
'''

class Solution:
    def jump(self, nums: List[int]) -> int:
        
#         if len(nums) == 1:
#             return 0
        
        q = collections.deque()
        q.append(0)
        
        level = 0
        while len(q) != 0:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if curr == len(nums) - 1:
                    return level
                
                for j in range(1,nums[curr]+1):
                    q.append(curr + j)
            level += 1
            
        return -1
    

'''
Using DFS (Pending)
'''
class Solution:
    def jump(self, nums):

        n = len(nums)
        self.hm = dict()
        return self.dfs(nums, n, 0)

    def dfs(self, nums, n, index):
        # base
        if index >= n - 1:
            return 0

        if index in self.hm:
            return self.hm[index]

        # logic
        a = 9999
        for j in range(1, nums[index] + 1):
            ni = index+j
            b = self.dfs(nums, n, index + j)
            a = min(a, b)
        self.hm[index] = a + 1
        return self.hm[index]


    
'''
Using Greedy
Time: O(n)
Space: O(1)
'''

class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        
        n = len(nums)
        currInt = nums[0]
        nextInt = nums[0]
        jumps = 1
        
        for i in range(1, n):
            nextInt = max(nextInt, i + nums[i])
            if i != n-1 and i == currInt:
                jumps += 1
                currInt = nextInt
        return jumps
        
