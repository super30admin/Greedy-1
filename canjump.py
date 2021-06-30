from typing import List
from collections import deque
import collections


class Solution:
    def canJumpbfs(self, nums: List[int]) -> bool:

        if nums is None or len(nums) == 0: return False
        myqueue = deque()
        myqueue.append(0)
        mapnode = collections.defaultdict(bool)
        mapnode[0] = True

        while myqueue.__len__() > 0:
            size = myqueue.__len__()
            for idx in range(size):
                index = myqueue.popleft()
                if index == len(nums) - 1: return True
                for nextjump in range(1, nums[index] + 1):
                    if mapnode[index + nextjump] == False:
                        if (index + nextjump) == len(nums) - 1: return True
                        myqueue.append(index + nextjump)
                        mapnode[index + nextjump] = True

        return False


from collections import deque
import collections


class Solution:
    def canJump(self, nums: List[int]) -> bool:

        if nums is None or len(nums) == 0: return False
        #         myqueue = deque()
        #         myqueue.append(0)
        #         mapnode = collections.defaultdict(bool)
        #         mapnode[0] = True

        #         while myqueue.__len__() > 0:
        #             size = myqueue.__len__()
        #             for idx in range(size):
        #                 index = myqueue.popleft()
        #                 if index == len(nums) - 1: return True
        #                 for nextjump in range(1, nums[index]+1):
        #                     if mapnode[index+nextjump] == False:
        #                         if (index + nextjump) == len(nums) - 1: return True
        #                         myqueue.append(index + nextjump)
        #                         mapnode[index+nextjump] = True
        return self.dfs(nums, 0)

    def dfs(self, nums, index):

        if index >= len(nums) - 1:
            return True

        for jump in range(1, nums[index] + 1):
            if self.dfs(nums=nums, index=index + jump): return True

        return False
nums = [2, 3, 1, 1, 4]
print(Solution().canJump(nums=nums))


# GRIDDY
class Solution:
    def canJump(self, nums: List[int]) -> bool:

        if nums is None or len(nums) == 0: return False
        destination = len(nums) - 1
        for idx in range(len(nums) - 2, -1, -1):
            if idx + nums[idx] >= destination:
                destination = idx

        return destination == 0




