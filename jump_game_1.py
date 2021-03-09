# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I store the current max and next max reach. curent next max reach is the max index reach from curr index and element that we can reach the current index
# whenever current max == i == last index, I return true else I return false

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) < 2: return True
        cm = nums[0]
        nm = nums[0]

        for i in range(1, len(nums)):
            nm = i + nums[i] if i + nums[i] > nm else nm
            
            if cm == i and i < len(nums)-1:
                cm = nm

                
            if cm >= len(nums)-1:
                return True
                
        return False
