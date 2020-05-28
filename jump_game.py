"""
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        """
        Idea is to construct a tree which consists of branching to all possible indexes from the start index using the maximum jump length at the position till it reaches the end 
        Algo fn(arr, i)
        - Base case - if i == n - 1: return True
                    - if arr[i] == 0 and i < n-1: return False # dead end
        - Rec case
            - for pos = 1 to arr[i]
                - if fn(arr, pos+i) 
                    return True
            return False
        """
        memo = {}
        def helper(nums,i):
            print(i,nums[i])
            if i in memo:
                return memo[i]
            if i == len(nums) - 1:
                return True
            if nums[i] == 0 and i < len(nums) - 1:
                return False
            
            for pos in range(1,nums[i]+1):
                if helper(nums, pos + i):
                    memo[pos+i] = True
                    return True
            memo[i] = False
            return False
        
        return helper(nums,0)