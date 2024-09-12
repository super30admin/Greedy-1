# // Time Complexity :  O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach

# Intuition:
# Brute Force: start from the first index and try each index how to reach till last index, get all possible paths until they return False(last index can't be reached). If a path leads to last index, return True. TC: upper bounded by O(N^N)
#Optimal: If you start from the end(we know we have to come to), we'll find the most optimal way to reach last index. If we start from the beginning, we'll keep exploring all possible paths from starting point. At the last index(destination), we need to look out if we can reach there from the previous index. If we can, that index can be our new destination and we just need to find out if we can take any path from previous indices to the new destination. Now, if our destination is at 0 that means we can return True.

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums or len(nums)==0 :
            return True
        n= len(nums)
        dest = n-1
        
        for i in range(n-2, -1 , -1):
            if nums[i]+i >= dest:
                dest = i
                
        return dest == 0 
        
    