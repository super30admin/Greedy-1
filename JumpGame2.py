'''
time complexity: O(n)
space complexity: O(1)
Greedy
'''
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if(n<2): return 0
        curr = nums[0]
        nexti = nums[0]
        
        jump = 1

        for i in range(1,len(nums)):
            nexti = max(nexti,i+nums[i])
            if(i!=n-1 and i==curr):
                jump+=1
                curr = nexti
        return jump
  
''''
BFS version
time complexity: O(n)
space complexity: O(1)
'''      

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)

        visited = set()
        q = deque([])
        visited.add(0)
        q.append(0)
        
        jump = 0
        while(len(q)!=0):
            sz = len(q)
            for j in range(sz):
                curr = q.popleft()
                if(curr>=n-1): return jump
                for i in range(1,nums[curr]+1):
                    newIdx=curr + i
                    if(newIdx not in visited):
                    
                        visited.add(newIdx)
                        q.append(newIdx)
            jump+=1
        return 0