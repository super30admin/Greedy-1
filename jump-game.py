class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # tc O(n), sc O(1).
        target = len(nums)-1

        for idx in range(len(nums)-2, -1, -1):
            if idx + nums[idx] >= target:
                target = idx
        
        return target == 0