#Time Complexity : O(N)
#Space Complexity : O(1)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        count = len(nums) - 1
        destindex = len(nums) - 1
        for i in range(len(nums) -2,-1,-1):
            if nums[i] + i >= destindex:
                destindex = i
                
        return True if destindex == 0 else False