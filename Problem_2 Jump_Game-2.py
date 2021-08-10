# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def jump(self, nums: List[int]) -> int:
        if nums == None or len(nums) <2:
            return 0
        jumps = 1
        curr = nums[0]
        nextv = nums[0]
        for i in range(1,len(nums)):
            #Continuously find how far we can reach in the curr jump
            nextv = max(nextv,nums[i] + i)
            if i < len(nums)-1 and i>=curr:
                #if curr jump ends, then make another jump
                jumps+=1
                curr = nextv
        return jumps