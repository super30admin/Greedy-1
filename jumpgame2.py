# using recursion
# begin from index 0. 
# reach the indices that are reachable from the current index.
# calculate the minimum steps required to reach the end.
# return the minimum no of steps required.
# Time complexity - O(n^n)
# Space complexity - O(n) worst case -- all the indices will be in the stack at a point
# Did this code run on leetcode? - yes

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        self.minsteps = n+1
        self.find_reachable(nums, 0, 0, n)
        return self.minsteps
    
    # find the reachable node
    def find_reachable(self, nums, index, step, n):
        # base case
        if index>=n-1: 
            self.minsteps = min(self.minsteps, step)
        else:  # recursive case (logic)
            for j in range(1, nums[index]+1):
                self.find_reachable(nums, j+index, step+1, n)


# Greedy solution. 
# traverse the nums once.
# keep a variable maxreachable, reachable, and no of jumps required.
# if nums is empty, return 0
# keep a track of maxreachable at every index.
# if the index is greater than the reachable index, update the jumps required. and also update the reachable index from that index to the maxreachable.
# return the jumps.
# This solution works since we take a jump only if we have reached the maximum node reachable from the previous jump index.
# time complexity - O(n)
# space complexity - O(1) 
# did this solution run on leetcode? - yes
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n==1: return 0
        maxreachable = 0
        reachable = 0
        minjump = 0
        
        for i in range(n):
            if reachable<i:
                reachable = maxreachable
                minjump += 1
            maxreachable = max(maxreachable, i+nums[i])
        return minjump


# using dynamic programming
# keep record of jumps to reach each index.
# time complexity - O(n^2)
# space complexity - O(n) 
# did this solution run on leetcode? - No (TLE)
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        # record the minimum jumps to reach each index
        jumps = [float('inf')] * n
        jumps[0] = 0
        
        for i, num in enumerate(nums):
            maxidx = min(i+nums[i]+1, n)
            for j in range(i, maxidx):
                jumps[j] = min(jumps[j], jumps[i]+1)
           
        return jumps[-1]
                