class Solution:
    # Time Complexity - O(n) -> filled with ones, left and right pass - 3 times traverse
    # Space Complexity - O(n)
    def candy(self, ratings) -> int:
        if ratings is None or len(ratings) == 0: return 0
        n = len(ratings)
        candies = [1] * n
        # Check left neighbors of each element
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i - 1] + 1

        result = candies[n - 1]
        # Check right neighbors of each element
        for i in range(n - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                candies[i] = max(candies[i], candies[i + 1] + 1)

            result += candies[i]

        return result