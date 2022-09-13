# TC: O(n)
# SC: O(1)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def jump(self, nums: List[int]) -> int:
        jumps = 0
        
        #start of level and end of level - we are doing 1D BFS
        startl = 0
        endl = 0
            
        
        # do this until endoflevel points in array bound
        while endl<len(nums)-1:
            #reset farthest point
            farthest =0
            #level wise processing
            for i in range(startl,endl+1):
                farthest = max(farthest,i+nums[i])
                
            #end of level - reset start and end
            startl = endl+1
            endl = farthest
            jumps+=1
                
                
        return jumps