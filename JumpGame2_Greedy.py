class Solution:
    def jump(self, nums: List[int]) -> int:
        # Time Complexity: O(n)
        # Space Complexity: O(1)
        n = len(nums)
        if n < 2:
            return 0
        curr_max = nums[0]
        nxtmax = nums[0]
        jumps = 1
        
        for i in range(1,len(nums)):
            if(curr_max>=len(nums)-1):
                return jumps
            nxtmax = max(i+nums[i], nxtmax)
            if(i==curr_max):
                curr_max = nxtmax
                jumps+=1
            
