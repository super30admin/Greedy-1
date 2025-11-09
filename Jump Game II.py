#  Time Complexity : O(N)   
#  Space Complexity : O(1)  
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english: Initially currInt is the first element of the array. Initially we consider the maxInt as the 1st element of the array. We start iterating from the 2nd element. We calculate the max value and keep a track of the max value as the maximum value between the prev max value and the max index we can reach. When we reach the max value we can reach from the particular index we increase the jump by 1. Also we make currInt equal to maxInt.  


class Solution:
    def jump(self, nums: List[int]) -> int:
        # TC: O(n)   SC: O(1)
        n = len(nums)
        maxInt = nums[0]
        currInt = nums[0]
        if n == 1:
            return 0
        jumps = 1
        for i in range(1, n):
            maxInt = max(maxInt, i + nums[i])

            if i != n - 1 and i == currInt:
                jumps += 1
                currInt = maxInt
            
        return jumps