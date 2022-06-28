#Time Complexity : O(N)
#Space Complexity : O(1)
class Solution:
    def jump(self, nums: List[int]) -> int:
        curr = nums[0]
        nextt = nums[0]
        count = 1
        if len(nums) < 2:
            return 0
        for i in range(0,len(nums)):
            nextt = max(nextt,nums[i] + i)
            if i == curr and i != len(nums) - 1:
                count +=1
                curr = nextt
                
        return count