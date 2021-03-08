# Brute Force - DFS Approach
# Time - O( N ^ 2) TLE
# Space - O(N) for recursive call stack

class Solution:
    def canJump(self, nums: List[int]) -> bool:

        if not nums or len(nums) < 2:
            return True
        
        return self.dfs(nums, 0)


    def dfs(self, nums, index):

        # base case
        if index >= len(nums) - 1:
            # we are able to reach destination
            return True


        # logic
        for jumps in range(1, nums[index] + 1):
            # from a position in the array, we are able to jump to position from 1 to value at that index

            if self.dfs(nums, index + jumps):
                return True

        return False


# Optimized Approach
# From jump game 2 logic
# Fix destination as last index 
# Jump from last second value and see if destination 0 ie index 0 is reached 

# Time - O(N)
# Space - O(1)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        if not nums or len(nums) < 2:
            return True
        
        destination = len(nums) - 1 # last position
        
        for i in range(len(nums) - 2, -1, -1):
            
            if i + nums[i] >= destination: # from i index jump positions = nums[i]
                destination = i
                
        if destination == 0:
            return True
        
        return False


# Optimised solution

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums is None or len(nums) < 2:
            return True
        
        nextJump = nums[0]
        
        for i in range(1, len(nums)):
            if i > nextInterval:
                return False
            
            nextJump = max(nextJump, nums[i]+i)
                
            if nextJump >= len(nums)-1:
                return True
        
        return False




                
                