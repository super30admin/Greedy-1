# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def jump(self, nums):
        count = 0
        current_jump = 0
        largest = 0
        #         We will check the the largest distance we can cover with  current jump
        #  If we reach to the end of current jump then we will make next jump
        for i in range(len(nums) - 1):
            largest = max(largest, i + nums[i])

            if i == current_jump:
                count += 1
                current_jump = largest

        return count

