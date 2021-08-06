class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        #greedy
        #time : O(n)
        if len(nums) < 2:
            return True
        dest = len(nums) - 1
        for i in xrange(len(nums)-2,-1,-1):
            if nums[i] + i >= dest:
                dest = i
        
        return dest == 0
        
        #dfs
        #time : exponential for both dfs and bfs
    #     if len(nums) < 2:
    #         return True
    #     self.pos_set = set()
    #     self.result = False
    #     self.dfs(nums,0)
    #     return self.result
    # def dfs(self,nums,idx):
    #     #base
    #     if idx == len(nums) - 1:
    #         self.result = True
    #         return
    #     if idx in self.pos_set or idx >= len(nums):
    #         return
    #     #logic
    #     self.pos_set.add(idx)
    #     for i in xrange(1, nums[idx] + 1):
    #         new_pos = idx + i
    #         self.dfs(nums, new_pos)
        #bfs
#         if len(nums) < 2:
#             return True
#         queue = deque()
#         pos_set = set()
        
#         queue.append(0)
#         pos_set.add(0)
        
#         while queue:
#             pos = queue.popleft()
#             for i in xrange(1,nums[pos]+1):
#                 new_pos = pos + i
#                 if new_pos not in pos_set:
#                     if new_pos == len(nums) - 1:
#                         return True
#                     queue.append(new_pos)
#                     pos_set.add(new_pos)
#         return False
