class Solution:
    def jump(self, nums: List[int]) -> int:
        """
        TC:O(n)
        SC:O(1)
        """
        if len(nums)==1:
            return 0
        
        jumps=1
        curInterval=nums[0]
        nextInterval=nums[0]
        for i in range(1, len(nums)):
            if i>curInterval:
                curInterval=nextInterval
                jumps+=1
            nextInterval=max(nextInterval, nums[i]+i)
        return jumps
        