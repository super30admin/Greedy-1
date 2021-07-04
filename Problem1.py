# Time Complexity: O (n)(Where n is total numbers) 
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# It can be solved by backtracking and memorization with O(n^2) time complexity.
# greedy approach can reduce time complexity.
# In greedy approach we consider that can we reach good position or not and we start checking it from the end.
class Solution:
#     Using backtrack with memorization gets timeout
#     def backtrack(self, index, nums):
#         if self.memo[index] != 2:
#             if self.memo[index] == 1:
#                 return True
#             else:
#                 return False
        
#         maxjump = min(index + nums[index], len(nums))
#         for nextp in range(index+1, maxjump + 1):
#             if self.backtrack(nextp, nums):
#                 self.memo[index] = 1
#                 return True
#         self.memo[index] = 0
#         return False
    
    def canJump(self, nums: List[int]) -> bool:
#       Last pointer keeps track of index from where we can reach the last element. From last element we can reach the last element.
        lastp = len(nums) - 1
#       Start iterating over numbers from last
        for jump in range(len(nums) - 1, -1, -1):
#           Check that current index plus jump value is greater than lastp or not and update last pointer accordingly.
            if nums[jump] + jump >= lastp:
                lastp = jump
#       In the end check that last pointer is at the first index or not
        return lastp == 0
