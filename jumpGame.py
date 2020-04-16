'''
MinHeap
Time Complexity:O(n)
Space Complexity:O(1)
Did this code successfully run on Leetcode : Yes
Explanation: Set destination as end of array, Start from the second last element  of the array, greedily check if
current index + number of steps >= destination if true update new destination as current index.

If we reach the starting of the array, this means there is a path from the end to start, hence we can jump, True.
'''
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums == None or len(nums) < 2:
            return True

        destination = len(nums) - 1

        for i in range(len(nums) - 2, -1, -1):
            if (i + nums[i]) >= destination:
                destination = i

        return destination == 0