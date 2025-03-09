#space: O(1)
#Time: O(n)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        if n == 0:
            return True
        target= n-1
        for i in range(n-2, -1,-1):

            if (i) + nums[i] >= target:
                target = i

        if target == 0:
            return True
        return False
