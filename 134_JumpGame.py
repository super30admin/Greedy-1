'''
Accepted on leetcode(55)
time - O(N)
space - O(1)
Approach:
1. Initialize lastIndex to the last index in the given array.
2. Iterate over the nums array from second last index. Here, we are doing so to verify if the last index is reachable from each index my moving from backwards.
3. Check the condition if index + number >= lastindex at that position then it is sure that the index is reachable, so change the last index to current index.
4. If the lastIndex is 0 at the end then there is a way from begin to end.
'''


class Solution:
    def canJump(self, nums) -> bool:
        lastIndex = len(nums) - 1

        for i in range(len(nums) - 2, -1, -1):
            if i + nums[i] >= lastIndex:
                lastIndex = i
        return lastIndex == 0