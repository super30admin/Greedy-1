# Leetcode : Pass
# TC - O(n), SC - O(1)
# nextInterval = the jump from the curr interval that can be made close to end of array
# intervalMax = the max index of curr interval
# 1) update nextInterval if curr_index+value at curr_index > nextInterval
# 2) when intervalMax==iterator then increase the jump and reset the new interval max value
# 3) if intervalMax==end of array, break and return jump value
class Solution:
    def jump(self, nums: List[int]) -> int:
        #edge case : 0/1 elem in array then 0jumps
        if len(nums) ==0 or len(nums)==1:
            return 0
        intervalMax = nums[0]
        nextInterval = nums[0]
        jump=1

        for i in range(1,len(nums)):
            #1
            if i+nums[i] > nextInterval:nextInterval=i+nums[i]
            #2
            if i==intervalMax and i != len(nums)-1:
                jump +=1
                intervalMax= nextInterval
            #3
            if intervalMax>= len(nums)-1:break
        return jump
