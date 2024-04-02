"""
Time Complexity : Exponential without use of hashset. This is because for every index we are trying to reach out to every possible step. 
                  But in this case it is n^2 where n is the length of nums as we will traverse every node only once and in worst case we can jump to every other index from the current index resulting in n^2.
Space Complexity : O(2n) = O(n) where n is the length of nums, in worst case queue can have all the elements of the nums and hashset will also have all the elements

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
We can do the level order traversal and at the end of each level increase the jump. Whenever we encounter the last index, return the jumps
"""
from queue import deque


class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n <= 1:
            return 0
        queue = deque()
        hashSet = set()

        queue.append(0)
        hashSet.add(0)
        jumps = 1

        while queue:
            size = len(queue)
            for i in range(size):
                currIdx = queue.popleft()
                currSteps = nums[currIdx]
                for j in range(1, currSteps+1):
                    newIdx = j + currIdx
                    if newIdx == len(nums) - 1:
                        return jumps
                    if newIdx not in hashSet:
                        queue.append(newIdx)
                        hashSet.add(newIdx)
            jumps += 1

        return jumps
