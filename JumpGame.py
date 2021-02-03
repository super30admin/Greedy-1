"""
Approach: Reverse approach

We start in reverse direction.

Algorithm:
1) Intialize destination with n-1 index.
2) Start from take an index one before destination
3) Check if that index + nums[index] >= dest. That means if we can reach our current destination using the number on the current index
4) If 3) is true update destination to current index
5) Follow steps 2) to 4) again until current index reaches the beginning index. 
6) If our destination index  is equal to 0 then we can reach the last index else we can not.

TC: O(n)
SC: O(1)

n = size of the nums array
"""
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums == None or len(nums) < 2:
            return True
        
        n = len(nums)
        dest = n - 1
        
        for i in range(n-2,-1,-1):
            if i+nums[i] >= dest:
                dest = i
                
        if dest == 0:
            return True
        
        return False