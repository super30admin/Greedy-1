'''
Solution:
1.  Here we perform optimal BFS without the help of a queue and with just a better visulaization.
2.  At each level, when index reaches the max scope of that level, we update scope to current 
    farthest and we also increment jumps at this point.
3.  We update farthest at each index anyway and break where farthest reaches or exceeds the last index.

Time Complexity:    O(N)    |   Space Complexity:   O(1)
--- Passed all test cases succesfully on leetcode.
'''


class Solution:
    def jump(self, nums: List[int]) -> int:
        
        #   edge case check
        if (nums == None or len(nums) < 2):
            return 0
        
        #   initializations
        jumps = 0           #   aka levels
        scope = 0           #   maximum reach for a particular level that is under processing
        farthest = 0        #   farthest jumps that can be reached at any point of time
        
        #   iterate the array
        for i in range(len(nums)):
            
            #   update farthest for each index and return if it reaches or exceeds last index
            farthest = max(farthest, i + nums[i])
            
            #   don't forget to return +1 to jumps
            if (farthest >= len(nums) - 1):
                return (jumps + 1)
            
            #   if index is at maximum reach of a level => increment level and maximum reach  
            if (i == scope):
                scope = farthest
                jumps += 1
           
        return (jumps)