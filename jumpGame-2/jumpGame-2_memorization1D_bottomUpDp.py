'''
Time Complexity: 0(n) * jumpsFactor
Space Complexity: 0(n) -- memory1D list
Run on leetCode: Yes
'''

'''
Approach: Memorization1D -- Bottom Up DP, fill up the memory from behind

1. Start from behind, as last index is our target, set its min-jump to 0
2. For other indexes, get the jumps count from nums, fill up the index memory with min-value possible
3. If my jump = 0, I will set the index memory with +inf
4. My answer will be at the 0th index with lowest count
'''

class Solution:
    
    def memorization1D(self,nums):
        
        # initlize a memory1D list
        memory1D = [0]*len(nums)
        
        # iterate the memory1D list from behind
        for idx in range(len(nums)-2,-1,-1):
            
            # get the possible jumps for the index
            jumps = nums[idx]
            
            # base-case --- if jumps == 0
            if jumps == 0:
                memory1D[idx] = float('inf') # set to infinity
                continue
            
            # iterate till jumpIdx breeches jumps
            minVal = None
            for i in range(1,jumps+1):
                tempIdx = idx + i
                
                if i == 1:
                    minVal = 1 + memory1D[tempIdx]
                    continue
                
                elif tempIdx < len(memory1D): 
                    minVal = min(minVal,1 + memory1D[tempIdx])
                    continue
                
                elif tempIdx == len(memory1D):
                    # end the iteration as tempIdx is breeching the length
                    break
                    
            '''end of for loop'''
            memory1D[idx] = minVal
        '''filled up memory1D'''
        
        # print the memory1D
        # print("Memory1D is:\t",memory1D)
        
        return memory1D[0]
    
    def jump(self, nums: List[int]) -> int:
        return self.memorization1D(nums)