
'''
Problem: Jump Game 2
Time Complexity: O(k ** n), where n is given elements and k is average jumps
Space Complexity: O(n) for queue
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        Applied BFS and check the destination at each level
        if at level we reach at destination, we return the level    
'''
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return 0
        queue = deque()
        queue.append(0)
        visited = set()
        visited.add(0)
        level = 0

        while queue:
            size = len(queue)
            for i in range(size):
                idx = queue.popleft()
                jump = nums[idx]
                for j in range(1, jump+1):
                    nIdx = idx+j
                    if nIdx == n-1:
                        return level+1
                    if nIdx not in visited:
                        queue.append(nIdx)
                        visited.add(nIdx)
            level+=1

        return level