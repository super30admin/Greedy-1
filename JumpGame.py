# Time - O(N)
# Space - O(1)
# back to start dp approach. starting from back and check if we reach that index, if yes then update the target index, if no return False.


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        dest = nums[len(nums)-1]
        
        for i in range(len(nums)-1,-1,-1):
            if nums[i] + i >= dest:
                dest = i
        if dest == i:
            return 1
        else:
            return 0
