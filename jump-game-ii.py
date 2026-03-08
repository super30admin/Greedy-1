#--------Solution 1 : BFS -------
''' Time Complexity : O(2^k) : k is average no of jumps
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return 0
        target = n-1
        sett = set()
        q = deque()
        q.append(0)
        sett.add(0)
        steps = 0
        while q:
            size = len(q)            
            for _ in range(size): 
                idx = q.popleft()
                for i in range(1,nums[idx]+1):
                    newidx = i + idx
                    if newidx == target:
                        return steps + 1
                    if newidx not in sett:
                        q.append(newidx)
                        sett.add(newidx)
            steps += 1
        


#--------Solution 2 : Greedy : Curr & next Interval -------
''' Time Complexity : O(n) : k is average no of jumps
    Space Complexity : O(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return 0
        target = n-1
        currInt= nums[0]
        nextInt = nums[0]
        jump = 1
        for i in range(n):
            nextInt = max(nextInt, i + nums[i])

            if i != target and i == currInt:
                jump += 1
                currInt = nextInt
        
        return jump

        