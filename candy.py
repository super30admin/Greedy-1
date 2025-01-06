# The candy method determines the minimum candies required to distribute such that:
# - Each child has at least one candy.
# - Children with higher ratings get more candies than their neighbors.

# Use two passes:
# - Left to right: Ensure higher-rated children than the left neighbor get more candies.
# - Right to left: Ensure higher-rated children than the right neighbor get more candies.

# Return the sum of candies as the result.

# TC: O(n) - Two passes over the ratings list.
# SC: O(n) - Space for the candies array.


from typing import List


class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        candies = [1] * n 

        for i in range(1, n):
            if ratings[i] > ratings[i-1]:
                candies[i] = candies[i-1] + 1

        for i in range(n-2, -1, -1):
            if ratings[i] > ratings[i+1]:
                candies[i] = max(candies[i], candies[i+1] + 1)
        
        return sum(candies)