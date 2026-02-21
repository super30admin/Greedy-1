class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums)==1: return True
        goal = len(nums)-1
        i = len(nums)-1
        while i > -1 :
            if i + nums[i] >= goal:
                goal = i
                if goal == 0:
                    return True
            i -=1
                
        return False
