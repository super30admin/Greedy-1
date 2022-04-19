# Time compleixty:- O(n)
# Space complexityL- O(1)
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        jumps = 0
        curentjumpend = 0
        nextjumpend = 0
        for i in range(len(nums)):
            nextjumpend = max(nextjumpend, i + nums[i])

            if i == curentjumpend and i != n - 1:
                jumps += 1
                curentjumpend = nextjumpend

        return jumps
