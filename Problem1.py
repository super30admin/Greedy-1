#Time - O(n)
#Space - O(1)
# 55 Jump game

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        destination = len(nums) - 1
        
        for i in range(len(nums) - 2, -1, -1):
            
            currIndex = i
            
            if(currIndex + nums[i] >= destination):
                
                destination = currIndex
        if destination == 0:
            return True
        else:
            return False
            