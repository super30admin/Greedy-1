class Solution:
    
    # Greedy --> Optimizing next interval
    # TC: O(N)
    # SC: O(1)
    
    def jump(self, nums: List[int]) -> int:
        
        if (len(nums) < 2):
            return 0
        
        jumps = 1
        currInt = nums[0]
        nextInt = nums[0]
        
        for i in range(1, len(nums)):
            
            nextInt = max(nextInt, nums[i]+i)
            
            if (currInt >= len(nums)-1):
                return jumps
            
            if (i == currInt):
                jumps += 1
                currInt = nextInt