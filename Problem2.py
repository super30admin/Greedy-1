# TC: O(N)
# SC: O(1)
# In this approach, we use a greedy approach to find the minimum number of jumps required to reach the end of the array.


class Solution:
    def jump(self, nums: List[int]) -> int:
        answer, n = 0, len(nums)
        cur_end, cur_far = 0, 0

        for i in range(n - 1):
            cur_far = max(cur_far, i + nums[i])

            if i == cur_end:
                answer += 1
                cur_end = cur_far

        return answer