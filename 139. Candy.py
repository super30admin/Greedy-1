class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        candies = [1 for i in range(n)]

        # left to right pass
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i - 1] + 1
        # right to left pass
        total = candies[n - 1]
        # total is initialized as n - 1
        # cause when iterating from right to left we start from 2nd last index

        for i in range(n - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                # we take the max value if value + 1 is greater than the right neighbor
                candies[i] = max(candies[i], candies[i + 1] + 1)
            total += candies[i]
        return total

# Greedy
# Time Complexity: O(2n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
