"""
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below(Greedy optimized)
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

        Time - O(N2) - Because we are trying to find good index for every position, lookin
        at the next nums[i] elements
        Space - O(N)
        """
        memo = {}
        def helper(nums,i):
            #print(i,nums[i])
            #print(memo)
            if i in memo:
                return memo[i]
            # if i == len(nums) - 1:
            #     return True
            # if nums[i] == 0 and i < len(nums) - 1:
            #     #dead end cannot reach last index
            #     return False
            furthestJump = min(i + nums[i], len(nums) - 1)
            for pos in range(i+1,furthestJump+1):
                #print(i, pos)
                #print(memo)
                # if pos + i in memo:
                #     return memo[pos+i]
                if helper(nums, pos):
                    memo[i] = True
                    return True
            memo[i] = False
            return False
        
        memo[len(nums)-1]=True
        f = helper(nums,0)
        #print(memo)
        return f

        """
        Greedy approach where we try to reach a good index from the right rather than searching
        for every good index to reach the end( it's kind of similar simulation to recursive, since recursively, the truth values are filled from the right itself)
        """
        n = len(nums)
        last_pos = n - 1
        for i in range(n-2,-1,-1):
            if nums[i] + i >= last_pos:
                last_pos = i
        return last_pos == 0