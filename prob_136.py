#leetcode - 45

class Solution:
    def jump(self, nums) -> int:

        # edge case
        if len(nums) in (0, 1):
            return 0
        # variables
        highesh_jump = nums[0]
        window_interval_len = nums[0]
        # return
        jumps = 1  # number of jumps

        # logic
        for i in range(len(nums)):
            if nums[
                i] + i > highesh_jump:  # case to find highes jump even in cases when the highestjump in the previous windows exceeds our current elemnt ex [2,3,1,9,4,5,6,7,1,1,1]
                highesh_jump = nums[i] + i
            if window_interval_len == i and i != len(
                    nums) - 1:  # if end ogf the window interval is reached and end of the nums array is not reached
                window_interval_len = highesh_jump  # from previous window
                jumps += 1
            if window_interval_len >= len(nums) - 1:  # end of nums is reached
                return jumps


