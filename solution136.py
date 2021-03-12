#Time Complexity:O(n)
#Space Complexity:O(1)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums)<2:									#if the array has just one element return true
            return True
        destination=len(nums)-1							#place pointer at the last index
        for i in reversed(range(len(nums)-1)):			#parse the array from last to first position
            if i+nums[i]>=destination:					#if the current index plus the value at the current undex is greater than or equal to
                destination=i 							#the destination pointer, move pointer to current position.
        return destination==0							#return true if the destination pointer is at 0 at the end of parse.