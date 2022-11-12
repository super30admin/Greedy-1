from collections import deque


class Solution:
    hashSet = {}

    def canJump(self, nums):
        if nums is None or len(nums) == 0:
            return False

        q = deque()
        q.append(0)
        self.hashSet = set()
        self.hashSet.add(0)

        while len(q) > 0:
            curr = q.popleft()
            for j in range(0, nums[curr] + 1):
                # print(j)
                i = curr + j
                if i >= len(nums) - 1:
                    return True

                if i not in self.hashSet:
                    self.hashSet.add(i)
                    q.append(i)
        return False


L = [2, 3, 1, 1, 4]
obj = Solution()
print(obj.canJump(L))


# BFS
# Time Complexity: O(n^2)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : No, Time Limit Exceeded
# Any problem you faced while coding this : No
