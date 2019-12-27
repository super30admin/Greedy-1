'''
Leetcode- 55. Jump Game - https://leetcode.com/problems/jump-game/
Time complexity - O(N)
space complexity - O(1)
Approach - if i+nums[i] > last_index then we update for each iteration

'''
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        last_index=len(nums)-1
        for i in range(len(nums)-2,-1,-1):
            if (i+nums[i])>=last_index:
                last_index=i
        return last_index==0
        