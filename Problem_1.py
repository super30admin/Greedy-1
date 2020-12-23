"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Here, I have solved it with 3 approaches. 1. recursive. 2. Greedy and starting from beginning. 3. Greedy and 
starting from last. I have commented the 1st and second approach. The time complexity of the recursive solution
would be exponential as we would be calculating every possible jump. For greedy approach and starting from
the back, for every index we check if we can reach there or not. We start from second last position and 
check if we can reach the last position. If yes, we move backwards but now our destination would be 
second last index and we check if we can reach there from third last. We continue with this until we traverse the
whole array and our destination becomes 0. If this is not the case, we return False. For another approach,
where we start from the beginning, it is almost the same like the previous approach. here, we check what can 
be the maximum position that we can reach from first index. When we go to second index, we again calculate the 
maximum position, but now its is the maximum of previous and curreny maximum. Likewise, we can iterate the whole
array. If after that, we are not able to reach the last, obviously we return false. We check this by checking
if at any index, the index becomes greater than the maximum position, that means we wont be able to reach
there with any number of jumps, hence False.
"""


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        l = len(nums)
        dest = l-1
        for i in range(l-2, -1, -1):
            if i + nums[i] >= dest:
                dest = i
        return not dest


"""
Below is the solution where we start from the beginning
"""
# class Solution:
#     def canJump(self, nums: List[int]) -> bool:
#         l=len(nums)
#         maxdest=0
#         for i in range(l):
#             if i>maxdest:
#                 return False
#             maxdest=max(maxdest,i+nums[i])
#         return True

"""
This is the recursive solution
"""
# class Solution:
#     def canJump(self, nums: List[int]) -> bool:
#         if not nums or len(nums)<2:
#             return True
#         return self.dfs(nums,0)

#     def dfs(self,nums,index):
#         if index==len(nums)-1:
#             return True

#         for i in range(1,nums[index]+1):
#             if self.dfs(nums,index+i):
#                 return True
#         return False
