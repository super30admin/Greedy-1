#
# @lc app=leetcode id=55 lang=python3
#
# [55] Jump Game
#

# @lc code=start

'''
Time Complexity - O(n). Using greedy method of intervals
Space Complexity - O(1).

Works on leetcode.
'''
from collections import deque
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        #BFS Using visited set. Else we get a TLE O(k^n)
        if len(nums)<2:
            return True
        #maintain a visited set for improved performance
        # visited = set()
        # queue = deque()
        #add first index to queue and visited set
        # queue.append(0)
        # visited.add(0)
        # while queue:
        #     #process the element in the queue     
        #     curr = queue.popleft() 
            # add all indices that have not been visited before that can be jumped to from the current position indicated by the value at the index.
        #     for i in range(1, nums[curr]+1):
        #         newPos = curr + i
            #if we find a position that is same as last element of the array or greater return True
        #         if newPos >= len(nums)-1:
        #             return True
        #         if newPos not in visited:
        #             queue.append(newPos)
        #             visited.add(newPos)
            #if queue gets exhausted and we dont reach the end, we return False
        # return False

        #DFS using a visited set
        self.visited = set()
        self.reach = False
        # return self.helper(nums, 0)

        #Greedy 1
        # target = len(nums)-1
        # for i in range(len(nums)-2, -1, -1):
        #     if i + nums[i] >= target:
        #         target = i
        # return target == 0
    
        #Greedy 2
        #The current and next interval will be current position + max length of jump taken from current location
        currInt = nums[0]
        nextInt = nums[0]
        #we iterate the entire array
        for i in range(len(nums)):
            #at each index it is checked if the next index can be moved ahead i.e. we check if a longer jump can be taken from the current index
            nextInt = max(nextInt, i+nums[i])
            #if we reach an index that marks end of current and next index but not the last index of the array, we cannot reach the end of the array.
            if i == currInt and nextInt == currInt and i!=len(nums)-1:
                return False
            #if we dont reach the end but the next interval points to a location beyond end of array we know we will reach the end, we return true
            if i!=len(nums)-1 and nextInt >= len(nums)-1:
                return True
            #when we reach the end of current Interval, the next interval become current interval.
            if currInt == i:
                currInt = nextInt
        #if we have reached the end of the array, we return True else false.
        if nextInt>=len(nums)-1:
            return True
        else:
            return False

    
    def helper(self, nums, idx):
        #if we reach the end of the array of beyond that we return True
        if idx >= len(nums)-1:
            return True
        #Try all possible jumps we can take from current position if the destination has not been visited before
        for i in range(1, nums[idx]+1):
            if idx+i in self.visited:
                continue

            if idx+i <= len(nums):
                if self.helper(nums, idx+i):
                    return True
            #in the end mark current index as visited
            self.visited.add(idx)
        
                
        
        


        
# @lc code=end

