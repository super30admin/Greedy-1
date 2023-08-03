# Time Complexity :  O(n)
# Space Complexity :O(1)
# Passed on Leetcode: yes

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return 0

        currInt = nums[0]
        nxtInt = nums[0]
        jump = 1

        for i in range(n):
            nxtInt = max(nxtInt, i + nums[i])
            if i == currInt:
                currInt = nxtInt
                jump += 1
            if currInt >= n-1:
                return jump

        return -1