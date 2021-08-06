from collections import deque
class Solution:
    """work from the last index 
    Time complexity-O(n)
    Space complexity-O(1)"""
    def canJump(self, nums: List[int]) -> bool:
        destination=len(nums)-1
        for i in range(len(nums)-2,-1,-1):
            if nums[i]+i>=destination:
                destination=i
        return destination==0
            
    """DFS Implementation--Time limit exceeded
    Time complexity-exponential
    Space complexity-O(n)"""
#     def __init__(self):
#         self.hashset=set()

#     def canJump(self, nums: List[int]) -> bool:
#         if len(nums)==1:
#             return True
#         return self.helper(nums,0)
    
#     def helper(self, nums, indx):
#         if indx==len(nums)-1:
#             return True
#         if indx in self.hashset:
#             return False
#         self.hashset.add(indx)
#         for i in range(nums[indx]):
#             if self.helper(nums,indx+i+1):
#                 return True
#         return False
            
        
        
    """BFS Implementation
        Time complexity-exponential
        Space complexity-O(n) where n is the length of nums"""
        # if len(nums)==1:
        #     return True
        # q=deque()
        # hashset=set()
        # q.append(0)
        # hashset.add(0)
        # while q:
        #     indx=q.popleft()
        #     for i in range(nums[indx]):
        #         newindx=indx+i+1
        #         if newindx not in hashset:
        #             if newindx==len(nums)-1:
        #                 return True
        #             q.append(newindx)
        #             hashset.add(newindx)
        # return False
                    
        