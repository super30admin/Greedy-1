# Time Complexity : O(n), Where n is number of elements in nums List
# Space Complexity : O(1)

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        dest = len(nums) - 1
        for i in range(len(nums)-2, -1, -1):
            if i + nums[i] >= dest:
                dest = i
        return dest == 0
