class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        target = n-1
        for i in range (n-2,-1,-1):
            if i+ nums[i]>=target:
                target = i
            
        return target == 0 
'''
       
        n = len(nums)
        if n <= 1:
            return True
        visited =[False] *n
        q= deque()
        q.append(0)
        while q:
            element = q.popleft()
            curr = nums[element]
            for i in range(1,curr+1):
                pos = element+i
                if pos >=n-1:
                    return True
                if not  visited[pos]:
                    visited[pos] = True
                    q.append(pos)
        return False
'''