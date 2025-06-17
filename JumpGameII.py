'''
    Time Complexity: O(n)
    Space Complexity: O(1)
'''
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return 0

        jumps = 1
        cur_int = max_int = nums[0]

        for i in range(1, n):
            if i > cur_int:
                cur_int = max_int
                jumps += 1

            max_int = max(max_int, i + nums[i])

        return jumps