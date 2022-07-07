# Time Complexity : O(N) where N elements in the array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Greedy Solution
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        
        nextInter = nums[0]
        currInter = nums[0]
        
        jumps = 0
        
        for i in range(1, n):
            nextInter = max(nextInter, i + nums[i])
            
            if i == currInter and i != n-1:
                jumps += 1
                currInter = nextInter
            
        return jumps + 1 if n >= 2 else 0