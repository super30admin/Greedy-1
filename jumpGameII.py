# TC: O(n)
# SC: O(1)
class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums)<2:
            return 0
        max_dist=0
        jumps=1
        idx=0
        curr=nums[0]
        while idx<len(nums):
            if idx>curr:
                jumps+=1
                curr=max_dist

            val=nums[idx]
            max_dist=max(max_dist, idx+val)
            
            idx+=1
        
        return jumps



            