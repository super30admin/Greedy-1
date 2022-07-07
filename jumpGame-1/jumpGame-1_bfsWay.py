'''
Time Complexity: exponential
Space Complexity: 0(n) -- Queue
Run on leetCode: Time Limit Exceed
'''
from collections import deque
class Solution:
    
    def canJump(self, nums: List[int]) -> bool:
        
        # base-case
        if len(nums) == 1:
            return True
        
        # initlize queue
        queue = deque([0]) # index 0 by default in the queu
        
        # initialize visitedDict
        visitedDict = {
            0: True
        }  # 0 is by default visited
        
        # initlize targetIndex
        targetIndex = len(nums)-1
        
        # maintain lvl
        lvl = 0
        
        # iterate the queue
        while len(queue) != 0:
            
            # maintain size
            size = len(queue)
            
            # pop the index from the queue
            index = queue.popleft()
            
            # get the jumps count
            jumps = nums[index]
            
            # iterate till size isnt breeched
            for count in range(0,size):

                # iterate till we are done with the jumps
                for i in range(1,jumps+1):

                    # initialize idx -- tempIdx
                    tempIdx = index + i

                    # chk conditionally
                    if tempIdx != targetIndex and tempIdx not in visitedDict:

                        # mark tempIdx as visited
                        visitedDict[tempIdx] = True

                        # append to the queue
                        queue.append(tempIdx)
                    
                    elif tempIdx == targetIndex:
                        # I am able to reach the targetIndex
                        return True
                    
                    continue
                '''done with jumps'''
            '''done with level iteration'''
            
            # update lvl
            lvl += 1
        
        '''end of queue iteration'''
        # update lvl
        lvl -= 1
        
        return False
        
        