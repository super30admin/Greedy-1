class Solution:
    def jump(self, nums: List[int]) -> bool:
        """using curr and next variables- calculate shortest jump
        Time complexity-O(n)
        Space complexity-O(1)"""
        if len(nums)==1:
            return 0
        jumps=1
        currinterval=nums[0]
        nextinterval=nums[0]
        for i in range(1, len(nums)):
            if i>currinterval:
                currinterval=nextinterval
                jumps+=1
            nextinterval=max(nextinterval, nums[i]+i)
        return jumps
        
    """DFS approach
    Time limit exceeded"""
#     def __init__(self):
#         self.jumps = float('inf')
        
#     def jump(self, nums: List[int]) -> bool:
#         if len(nums)==1:
#             return 0
#         self.helper(nums,0, 0)
#         return self.jumps
    
#     def helper(self, nums, indx, steps):
#         if indx==len(nums)-1:
#             self.jumps=min(self.jumps, steps)
#             return
#         for i in range(nums[indx]):
#             if indx+i+1<=len(nums)-1:
#                 self.helper(nums,indx+i+1, steps+1)

# class Solution:
#     def jump(self, nums: List[int]) -> int:
#         """BFS Implementation
#         Time complexity-exponential
#         Space complexity-O(n) where n is the length of nums"""
#         if len(nums)==1:
#             return 0
#         q=deque()
#         hashset=set()
#         q.append(0)
#         hashset.add(0)
#         jump=0
#         while q:
#             length=len(q)
#             jump+=1
#             for k in range(length):
#                 indx=q.popleft()
#                 for i in range(nums[indx]):
#                     newindx=indx+i+1
#                     if newindx not in hashset:
#                         if newindx==len(nums)-1:
#                             return jump
#                         q.append(newindx)
#                         hashset.add(newindx)
#         return jump
        