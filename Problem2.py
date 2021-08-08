# Time Complexity : O(n**2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#using dp to check from end in how many steps we can reach the to that particular point
class Solution:
    def jump(self, nums: List[int]) -> int:
        jumps = [0]*len(nums)
        for i in range(len(nums)-2,-1,-1):
            jump = nums[i]
            minStep = 99999999999999999
            for j in range(1,jump +1):
                if i+j < len(nums):
                    minStep = min(minStep, jumps[i+j])
            jumps[i] = minStep + 1
        return jumps[0]