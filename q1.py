# Time Complexity : O(n), Where n is number of elements in nums List
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from typing import List

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n=len(nums)
        des=n-1#Here we have initialized the destination
        for i in range(n-2,-1,-1):
            if(i+nums[i]>=des):
                #Here we can reach from i to des
                des=i
        return (des==0)