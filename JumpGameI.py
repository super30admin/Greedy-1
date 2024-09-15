"""
    // Time Complexity :O(n)
    // Space Complexity :O(1)
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : NA

    //Explanation:
    backward pass
    compare if nums[i] + [i] >= destination
    update destination if true else false
"""
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # edge
        if len(nums) < 2 or nums is None: return True

        n = len(nums)
        destination = n - 1

        for i in range(n-1,-1,-1):
            print(destination,nums[i],i,nums[i] + i >= destination)
            if nums[i] + i >= destination:
                destination = i


        if destination == 0:
            return True
        else:
            return False
