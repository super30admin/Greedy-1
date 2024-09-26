#Time Complexity : O(N) where N is number of elemeents
#Space Complexity :O(1)
class Solution:
    def jump(self, nums: List[int]) -> int:
        curr = 0
        next1 = 0
        jumps = 0
        if len(nums)==0 or len(nums)==1:
            return 0
        for i in range(len(nums)):
            next1 = max(next1,i+nums[i])
            if (next1 >= len(nums) - 1):
                return (jumps + 1)
            if i == curr:
                curr = next1
                jumps+=1
        return jumps