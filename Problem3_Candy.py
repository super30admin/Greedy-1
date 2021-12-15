# Time Complexity: O(n), where n - length of the input array
# Space Complexity: O(n)

class Solution:
    def candy(self, ratings: List[int]) -> int:
        if not ratings or len(ratings) == 0:
            return 0

        n = len(ratings)
        candies = [1 for x in range(n)]

        # Left pass - If curr rating is greater than the prev one, increment its candies
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i - 1] + 1

        # Right pass - If curr rating is greater than the next one, increment its candies
        for i in range(n - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                candies[i] = max(candies[i], candies[i + 1] + 1)

        # Return the sum of all candies
        result = 0
        for candy in candies:
            result += candy

        return result