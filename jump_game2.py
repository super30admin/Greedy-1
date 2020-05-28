"""
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below(Greedy optimized)
"""
class Solution:
    def jump(self, nums: List[int]) -> int:
        """
        Method1 - Recursive
        """
        min_jump = float("inf")
        def dfs(position,jumps):
            print(position)
            nonlocal min_jump
            if position == len(nums) - 1:
                min_jump = min(min_jump,jumps)
                return
            
            for i in range(1,nums[position]+1):
                dfs(i+position,jumps+1)
        dfs(0,0)
        return min_jump
        
        """
        Greedy Optimized
        Idea is to update the jump interval that gives us the farthest distance closest to the destination 
        We have the current interval and next interval initialized to 0 + num[0]
        for each element 
            - current index + nums[cure_index] > current_interbal -> next_interval = current index + nums[cure_index]
            - For each interval iteration(i == current interval)
                - increment jumps count
                - update current interval to next interval if i is greater than current interval (new interval starts)
        - return jumps count in the end
        """
        if not nums or len(nums) == 1:
            return 0
        
        curr_interval = 0 + nums[0]
        next_interval = 0 + nums[0]
        jumps = 1
        for i in range(1,len(nums)):
            next_interval = max(next_interval,i + nums[i])
            if i < len(nums) - 1 and i == curr_interval:
                curr_interval = next_interval
                jumps+=1
        return jumps