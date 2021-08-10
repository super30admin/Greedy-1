# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums == None or len(nums) <2:
            return True
        destination = len(nums)-1
        for i in range(len(nums)-2,-1,-1):
            if nums[i] + i >= destination:
                #Change the destination to curr index
                destination = i
        return destination == 0