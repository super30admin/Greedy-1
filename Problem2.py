# Time Complexity: O (n)(Where n is total numbers) 
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# greedy approach can reduce time complexity.

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
#       Cover edge cases
        if n == 0 or n == 1:
            return 0
#       Initilize jumps as 1 and we will start from 2nd element.
        jumps = 1
#       Set cur_max and next_max as first element
        cur_max = nums[0]
        next_max = nums[0]
#       Iterate over nums
        for i in range(1, n):
#           Update next_max as max from itself and index plus jump value at that index
            next_max = max(next_max, i + nums[i])
#           If current reaches the cur_max index, increment the jump and change cur_max's value to next_max
            if cur_max == i and i != n-1:
                jumps += 1
                cur_max = next_max
#           At any time cur_max exceeds index's we don't need to check anymore.
            if cur_max > n - 1:
                break
        
        return jumps
