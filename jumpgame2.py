#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if len(nums) == 1:
            return 0
        currInt = nums[0]
        nextInt = nums[0]
        jumps = 1
        for i in range(1,n-1):
            nextInt = max(nextInt, i+nums[i])
            if i==currInt:
                currInt = nextInt
                jumps += 1
                
        return jumps