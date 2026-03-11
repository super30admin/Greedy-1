# Time Complexity : O(n), n = number of children
# Space Complexity : O(n) for left->right and right->left arrays (can optimize to O(1))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. First pass: left to right, if child[i] > child[i-1], give one more candy than left neighbor.
# 2. Second pass: right to left, if child[i] > child[i+1], give max of current and right+1.
# 3. Sum all candies to get minimum total.

from typing import List

class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        candies = [1] * n
        
        # left to right
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i - 1] + 1
        
        # right to left
        for i in range(n - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                candies[i] = max(candies[i], candies[i + 1] + 1)
        
        return sum(candies)