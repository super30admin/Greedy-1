class Solution:
    
    """
    
            Name : Shahreen Shahjahan Psyche
            Language Used : Python
            Time : O(N)
            Space: O(1)
            Passed All The Test Cases in LC : Yes
            
            Approach : # Start from the destination and keep destination as new source
                       # Now, go back by 1 step at a time and check whether from the current step, can we end up in the current source
                         with the number of jumps that has been assigned. If yes, assign current step as new source. Otherwise, step back
                       # At the end, check whether Source == 0. If yes, that means we can end up to the deestination from the sourcee. So return
                         True else False
                        
                       
    
    """
    
    
    def canJump(self, nums: List[int]) -> bool:
        
        # edge case
        if len(nums) == 1:
            return True
        
        source = len(nums)-1
        
        for i in range(len(nums)-2, -1, -1):
            if source - i <= nums[i]:
                source = i 
                
        if source == 0:
            return True
        return False
        
