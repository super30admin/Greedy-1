#Time Complexity: O(N)
#Space Complexity: O(1)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        farthest = nums[0]
        count = 0
        best_step_reach = farthest
        for i, n in enumerate(nums):
            if i > farthest:
                farthest = best_step_reach
                count += 1
            tmp = i + n
            if tmp > best_step_reach:
                best_step_reach = tmp
            if best_step_reach >= len(nums) - 1:
                if i == 0:
                    count += 1
                else:
                    count += 2
                break
        return count