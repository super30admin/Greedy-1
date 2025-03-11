class Solution:
    # GREEDY PROBLEM
    # TC: O(n)
    # SC: O(1)
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        target = n-1
        for i in range(n-1,-1,-1):
            maxjump = nums[i]
            if i +maxjump >= target:
                target = i
        return target == 0