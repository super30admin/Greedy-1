# Time Complexity : O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : First go left to right and give one more candy if the rating increases.
# Then go right to left and fix if the kid deserves more.
# Finally, sum all the candies and return the result.

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

        count = 0
        for candy in candies:
            count += candy

        return count 

        