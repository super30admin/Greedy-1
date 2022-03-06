"""
There are n children standing in a line. Each child is assigned a 
rating value given in the integer array ratings.

You are giving candies to these children subjected to the 
following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to 
distribute the candies to the children.
"""

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def candy(self, ratings: List[int]) -> int:
        
        candies = [1] * len(ratings)
        n = len(ratings)
        sm = 0
        
        # left pass
        for i in range(1, n):
            if ratings[i] > ratings[i-1]:
                candies[i] = candies[i-1] + 1
                
        # right pass
        sm = candies[n-1]
        for i in range(n-2, -1, -1):
            if ratings[i] > ratings[i+1]:
                candies[i] = max(candies[i], candies[i+1] + 1)
            sm += candies[i]
            
        return sm
            
            
                