#Greedy
""""// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        target = n - 1
        for i in range(n - 2, -1, -1):
            if nums[i] + i >= target:
                target = i
        return target == 0

#BFS
""""// Time Complexity : O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

# class Solution:
#     def canJump(self, nums: List[int]) -> bool:
#         n=len(nums)
#         if n==1:
#             return True
#         q=deque()
#         h=set()
#         h.add(0)
#         q.append(0)
#         while q:
#             curr=q.popleft()
#             for i in range(1, nums[curr]+1):
#                 idx=curr+i
#                 if idx>=n-1:
#                     return True
#                 if idx not in h:
#                     h.add(idx)
#                     q.append(idx)
#         return False
