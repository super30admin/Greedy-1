class Solution:
    def candy(self, ratings):
        if not ratings:
            return 0
        n = len(ratings)
        candies = [1 for i in range(n)]
        # left to right
        for i in range(1, n):
            if ratings[i - 1] < ratings[i]:
                candies[i] = candies[i - 1] + 1

        # right to left
        for i in range(n - 2, -1, -1):
            if ratings[i + 1] < ratings[i]:
                candies[i] = max(candies[i], candies[i + 1] + 1)
        return sum(candies)