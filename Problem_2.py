#
# @lc app=leetcode id=45 lang=python3
#
# [45] Jump Game II
#

# @lc code=start
'''
Time Complexity - O(n)
Space Complexity - O(1)

Works on leetcode.
'''
class Solution:
    def jump(self, nums: List[int]) -> int:
        #Using Greedy (This is the most optimal)
        # #if we have only 1 number in the array. we are at the destination
        # if len(nums) < 2:
        #     return 0
        # #currently we can only go to index present at index 0
        # currInt = nums[0]
        # nextInt = nums[0]
        # #we will at least take 1 jump
        # jumps = 1
        # for i in range(len(nums)-1):
        #     #check if we can make bigger jumps from current position
        #     nextInt = max(nextInt, i+nums[i])
        #     #when we reach an index that is upto the current interval we will update current interval with the next interval and we will make an additional jump
        #     if i==currInt and i!=len(nums)-1:
        #         currInt = nextInt
        #         jumps+=1
        # return jumps
        
        #Using BFS
        # jumps = 0
        # queue = deque()
        # visited = set()
        # queue.append(0)
        # visited.add(0)
        # while queue:
        #     size = len(queue)
        #     for i in range(size):
        #         currIdx = queue.popleft()
        #         if currIdx == len(nums)-1:
        #             return jumps
        #         for j in range(1, nums[currIdx]+1):
        #             newPos = currIdx + j
        #             if newPos not in visited:
        #                 queue.append(newPos)
        #                 visited.add(newPos)
        #     jumps+=1
        # return jumps

        #Using DFS
        self.dp = {}
        return  self.helper(0, nums)
    
    
    def helper(self, currIdx, nums):
        # print(f"{currIdx}: {jumps}")
        if currIdx >= len(nums)-1:
            return 0
        if currIdx in self.dp:
            return self.dp[currIdx]
        minJumps = 1e6
        for j in range(1, nums[currIdx]+1):
            minJumps = min(minJumps, self.helper(currIdx+j, nums))
        self.dp[currIdx] = 1+minJumps
        return 1+minJumps
        
# @lc code=end

