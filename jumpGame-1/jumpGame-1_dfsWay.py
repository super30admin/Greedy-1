'''
Time Complexity: exponential
Space Complexity: recursive stack 0(n)
Run on leetCode: Time Limit Exceed
'''
class Solution:
    
    def __init__(self):
        self.__visitedDict = {}
    
    '''return boolean'''
    def dfsTraversal(self,nums,index,target):
        # base-case
        if index == target:
            return True
        
        elif index != target and index in self.__visitedDict:
            return None
        
        # logic-case
        # 1. mark index as visited
        self.__visitedDict[index] = True    
        
        # 2. get jumps
        jumps = nums[index]
        
        # 3. iterate the index for jumps
        for i in range(1,jumps+1):
            # intialize tempIndex
            tempIndex = index + i
            
            # recurse 
            result = self.dfsTraversal(nums,tempIndex,target)
            
            # chk the result 
            if result == True:
                return result
            # else -- just continue checking for other index possibilities
        '''end of iteration'''
        
        
    def canJump(self, nums: List[int]) -> bool:
        result = self.dfsTraversal(nums,0,len(nums)-1)
        if result:
            return result
        else:
            return False