#In this solution, we check where the next jump takes to and select the better jump that brings closer to the end index.
#Time complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def jump(self, nums: List[int]) -> int:
        if nums == None or len(nums) < 2:
            return 0
        currInt = nums[0]
        nextInt = nums[0]
        jumps = 1
        for i in range(1,len(nums)):
            nextInt = max(nextInt,nums[i]+i)
            if currInt!= len(nums) - 1 and currInt == i:
                currInt = nextInt
                jumps += 1
        return jumps