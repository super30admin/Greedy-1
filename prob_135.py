# leetcode 55
# algo : we check from last element nad check if we can get to each elemnt from its previous elements and keep changing the last index-- [3,2,1,0,4]
# time -
# space -
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # variables
        last_index = len(nums) - 1
        # logic
        for i in range(len(nums) - 2, -1, -1):
            if i + nums[i] >= last_index:
                last_index = i
        return (last_index == 0) 
