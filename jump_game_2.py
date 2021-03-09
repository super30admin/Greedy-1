# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I track current max and next max and each time my index reaches current max reach I increment the jump variable. current max is when index reaches
# the previous next max and next max is the furthest reach from current element and elements that can be reached from current element.

class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) < 2: return 0
        cm = nums[0]
        nm = nums[0]
        j = 1
        for i in range(1, len(nums)):
            nm = i + nums[i] if i + nums[i] > nm else nm
            
            if cm == i and i < len(nums)-1:
                cm = nm
                j+=1
                
            if cm >= len(nums)-1:
                break;
                
        return j
                
