#Time: O(n)
#Space: O(1)
#Program ran on leetcode successfully

class Solution:
    def jump(self, nums: List[int]) -> int:
        currNum = nums[0]
        nextNum = nums[0]
        
        if len(nums) < 2:
            return 0
        
        res = 1
        
        for i in range(1, len(nums)):
            nextNum = max(nextNum, i + nums[i])
            if (i == currNum and i != len(nums) - 1):
                res += 1
                currNum = nextNum
        
        return res
        