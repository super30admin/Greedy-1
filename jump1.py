#Time Complexity : O(N) where N is number of elemeents
#Space Complexity :O(1)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if (nums == None or len(nums) < 2):
            return True
        destination = len(nums) - 1
        for i in range(destination - 1, -1, -1):
            if (i + nums[i] >= destination):
                destination = i     
        return (destination == 0) 