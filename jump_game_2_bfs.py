# Time Complexity : O(N^M) where N elements in the array and M is max (jump capacity/strength) number in the array
# Space Complexity : O(N) where N is number of elements in the array. Used for hashset and queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#BFS Solution
class Solution:
    def jump(self, nums: List[int]) -> int:
        end = len(nums) - 1
        hashset = set()
        q = deque()
        q.appendleft(0)
        hashset.add(0)
        jumps = 0
        
        while len(q) != 0:
            size = len(q)
            for _ in range(size):
                index = q.pop()
                if index >= end: return jumps
                for i in range(1, nums[index] + 1):
                    nextIndex = index + i

                    if nextIndex not in hashset:
                        q.appendleft(nextIndex)
                        hashset.add(nextIndex)
                        
            jumps += 1
                    
        return -1