class Solution:
    def candy(self, ratings: List[int]) -> int:
        # T: O(n), S: O(n)
        n = len(ratings)
        candies = [1] * n  # Step 1: Give each child 1 candy initially

        # Left-to-right pass
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i - 1] + 1

        # Right-to-left pass
        for i in range(n - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                candies[i] = max(candies[i], candies[i + 1] + 1)

        return sum(candies)
