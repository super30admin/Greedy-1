class Solution:
    """
    TC:O(n)
    SC:O(1)
    """
    def canJump(self, nums: List[int]) -> bool:
        destination= len(nums)-1
        for i in range(len(nums)-2,-1,-1):
            if nums[i]+i>=destination:
                destination=i
        return destination==0
    
    
    
    
        """
        DFS
        TC:exponential- TTL
        SC:O(length of recursive stack)=O(n)
        """
    
#     def __init__(self):
#         self.s=set()
    
#     def canJump(self, nums: List[int]) -> bool:
        
#         if len(nums)==1:
#             return True
#         return self.dfs(nums,0)
    
#     def dfs(self,nums,index):
#         # base
#         if index==len(nums)-1:
#             return True
        
#         if index in self.s:
#             return False
        
#         self.s.add(index)
#         for i in range(nums[index]):
#             if self.dfs(nums, index+i+1):
#                 return True
#         return False
        
        
        
#         """
#         BFS
#         TC:exponential
#         SC:O(n), length of queue
#         """
#         if len(nums)==1:
#             return True
#         s=set()
#         q=collections.deque()
#         q.append(0)
#         s.add(0)
#         while q:
#             index=q.popleft()
#             for i in range(nums[index]):
#                 newind=index+i+1
#                 if newind not in s:
#                     if newind==len(nums)-1:
#                         return True
#                     q.append(newind)
#                     s.add(newind)
#         return False
        