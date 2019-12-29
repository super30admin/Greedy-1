# Leetcode : Pass
# TC - O(n), SC - O(1)
# Traverse backwards. curr_index+value at curr_index >= lastIndex implies that the lastIndex can be reached
# 1) Start from second last elem
# 2) if curr_index+value at curr_index >= lastIndex then update the lastIndex to curr_index and find if the new lastIndex can be
#    reached from any other index before curr_index
# 3) if lastIndex==0 => can reach end_of_array
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        lastIndex = len(nums)-1
        #1
        for i in range(len(nums)-2,-1,-1):
            #2
            if i+nums[i] >= lastIndex: lastIndex=i
        #3
        return lastIndex==0
