'''
1. We use BFS technique to keep track of the window that can be reached with each step.
2. The steps required to reach that particular index would then be how many windows we had (0 indexed)

TC: O(n)
SC: O(n)
'''

class Solution:
    def jump(self, nums: List[int]) -> int:
        l = r = 0
        steps = 0

        while r < len(nums) - 1:
            new_r = 0
            for i in range(l, r + 1):
                new_r = max(new_r, i + nums[i])
            l = r + 1
            r = new_r
            steps += 1
        return steps