'''
Time Complexity: 0(n)
Space Complexity: 0(1)
Run on leetCode: Yes
'''

'''
GREEDY ON INTERVALS:
With current "jump", I am able to make my "nextInterval" as MAXIMUM
'''
class Solution:
    def jump(self, nums: List[int]) -> int:
        
        # base-case
        if len(nums) == 1:
            return 0
        
        # logic-case
        # 1. initlize variables
        minJump = 1
        currentInterval = nums[0]
        nextInterval = nums[0]
        
        # base-case ---> currentInterval == len(nums)-1
        if currentInterval == len(nums)-1:
            # example: [2,3,1,1,4] --> chk on whiteboard
            return minJump
        
        # start from index 0
        index = 1
        while index != len(nums):
            
            # update the nextInterval to maximum
            nextInterval = max(nextInterval,index+nums[index])
            
            # case: index == currentInterval
            if index == currentInterval:
                minJump += 1
                currentInterval = nextInterval
                
            # chk if currentInterval is reaching the last index
            if currentInterval == len(nums)-1:
                # example: [2,3,1,1,4] --> chk on whiteboard
                break
            
            # update the index
            index += 1
        '''end of greedy max'''
        
        #  print the minJump
        # print("MinJump is:\t",minJump)
        return minJump