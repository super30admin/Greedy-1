'''
time complexity: O(n)
space complexity: O(1)
'''
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if(len(nums)<=1): return True
        target = len(nums)-1
        for i in range(len(nums)-2,-1,-1):
            if(i+nums[i]>=target):
                target=i
        return target==0


''''
BFS version
time complexity: O(n)
space complexity: O(1)
time limit exceeded
'''
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if(len(nums)<=1): return True
        visited = set()
        q = deque([])
        visited.add(0)
        q.append(0)
        n=len(nums)
        while(len(q)!=0):
            curr = q.popleft()
            
            for i in range(1,nums[curr]+1):
                newIdx=curr + i
           
                if(newIdx>=n-1): return True
                visited.add(newIdx)
                q.append(newIdx)
        return False