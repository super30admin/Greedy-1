# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List


class Solution:
    def candy(self, ratings: List[int]) -> int:

        n = len(ratings)
        candies = [1] * n  # initially every kid is given one candy

        # checking and comparing for the left side kids
        for i in range(1, n):
            # if rating of current kid is greater than the kid to the left; increment the candies of next kid
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i - 1] + 1

        # checking and comparing for the right side kids
        for i in range(n-2, -1, -1):
            # if rating of current kid is greater than the kid to the right; increment the candies of next kid
            if ratings[i] > ratings[i + 1]:
                candies[i] = max(candies[i], candies[i + 1] + 1)

        return sum(candies)
