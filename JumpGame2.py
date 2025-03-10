
class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return 0  # No jumps needed if the array is empty or has only one element
        n = len(nums)
        currInterval = nums[0]
        nextInterwal = nums[0]
        jumps = 1
        for i in range(n):
            nextInterwal = max(nextInterwal, i+ nums[i])
            if i < n -1 and i == currInterval:
                jumps = jumps +1
                currInterval = nextInterwal
        return jumps

   # Tc = O(n)
   # SC = O(1)