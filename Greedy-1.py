# Greedy-1

## Problem1 Jump Game (https://leetcode.com/problems/jump-game/)

from typing import List

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_reach = 0
        for index, jump_length in enumerate(nums):
            if max_reach < index:
                return False
            max_reach = max(max_reach, index + jump_length)
        return True
# TC = O(n); SC = O(1)
           
## Problem2 Jump Game II (https://leetcode.com/problems/jump-game-ii/)

class Solution:
    def jump(self, nums: List[int]) -> int:
        jump_count = max_reach = last_reach = 0
        for index, value in enumerate(nums[:-1]):
            max_reach = max(max_reach, index + value)
            if last_reach == index:
                jump_count += 1
                last_reach = max_reach
        return jump_count
# TC = O(n); SC = O(1)

## Problem3 Candy (https://leetcode.com/problems/candy/)

from typing import List

class Solution:
    def candy(self, ratings: List[int]) -> int:
        # Length of the ratings list
        num_children = len(ratings)
      
        # Initialize lists to represent the minimum candies for each child from left and right perspectives
        candies_from_left = [1] * num_children
        candies_from_right = [1] * num_children
      
        # Calculate the minimum candies required from the left perspective
        for i in range(1, num_children):
            # If the current child has a higher rating than the previous child, 
            # give one more candy than the previous child
            if ratings[i] > ratings[i - 1]:
                candies_from_left[i] = candies_from_left[i - 1] + 1
      
        # Calculate the minimum candies required from the right perspective
        for i in range(num_children - 2, -1, -1):
            # If the current child has a higher rating than the next child,
            # give one more candy than the next child
            if ratings[i] > ratings[i + 1]:
                candies_from_right[i] = candies_from_right[i + 1] + 1
      
        # Sum the max number of candies required from both perspectives for each child
        # to ensure all conditions are met
        total_candies = sum(max(candies_left, candies_right) for candies_left, candies_right in zip(candies_from_left, candies_from_right))
      
        return total_candies
# TC = O(n); SC = O(n)