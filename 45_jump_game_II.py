from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        """"
            https://leetcode.com/problems/jump-game-ii/
            Time Complexity - O(n)
            Space Complexity - O(1)
            'n' is the length of nums
        """
        if len(nums) <= 1:
            return 0
        cur_interval = next_interval = nums[0]
        jumps = 1
        for level in range(1, len(nums) - 1):
            next_interval = max(next_interval, level + nums[level])
            if level == cur_interval:
                cur_interval = next_interval
                jumps += 1
        return jumps


if __name__ == '__main__':
    print(Solution().jump([1, 4, 3, 7, 1, 2, 6, 7, 6, 10]))
    print(Solution().jump([3, 2, 1, 0, 4]))
    print(Solution().jump([3, 4, 2, 1, 1, 2, 2, 1]))
