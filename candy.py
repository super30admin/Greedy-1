## Problem3 Candy (https://leetcode.com/problems/candy/)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        candies = [1] * len(ratings)
        ###forwardpass
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i - 1]:
                candies[i] = 1 + candies[i - 1]
        ###backwardpass
        for i in range(len(ratings) - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                candies[i] = max(candies[i], 1 + candies[i + 1])
        return sum(candies)





