class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #greedy: O(n)
        if len(nums) < 2:
            return 0
        currInt = nums[0]
        nextInt = nums[0]
        jumps = 1
        for i in xrange(1,len(nums)):
            nextInt = max(nums[i]+i,nextInt)
            if i < len(nums) - 1 and i == currInt:
                jumps += 1
                currInt = nextInt
        return jumps
        
                #dfs
        #time : exponential for both dfs and bfs
    #     if len(nums) < 2:
    #         return 0
    #     self.jumps = float('inf')
    #     self.dfs(nums,0,0)
    #     return self.jumps
    # def dfs(self,nums,idx,jumps):
    #     #base
    #     if idx >= len(nums) - 1:
    #         self.jumps = min(jumps,self.jumps)
    #         return
    #     #logic
    #     for i in xrange(1, nums[idx] + 1):
    #         new_pos = idx + i
    #         self.dfs(nums, new_pos,jumps+1)
        #bfs
#         if len(nums) < 2:
#             return 0
#         queue = deque()
#         pos_set = set()
#         jumps = 0
#         queue.append(0)
#         pos_set.add(0)
        
#         while queue:
#             size = len(queue)
#             for i in xrange(size):
#                 pos = queue.popleft()
#                 for i in xrange(1,nums[pos]+1):
#                     new_pos = pos + i
#                     if new_pos not in pos_set:
#                         if new_pos == len(nums) - 1:
#                             return jumps + 1
#                         queue.append(new_pos)
#                         pos_set.add(new_pos)
#             jumps += 1
#         return jumps
