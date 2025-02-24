'''
1. We assign each child one candy to satisfy condition 1
2. In first pass, we check if the left neighbor has lesser ratings and increase the current child's candies.
3. In second, we check for right neighbor.

TC: O(n)
SC: O(n) -> candies array
'''

class Solution:
    def candy(self, ratings: List[int]) -> int:
        if not ratings or len(ratings) == 0:
            return 0

        n = len(ratings)
        # Assign 1 candy each for all children
        candies = [1] * n

        # Left neighbor check
        for i in range(1, n):
            if ratings[i] > ratings[i-1]:
                candies[i] = candies[i-1] + 1
        
        total = candies[-1]

        # Right neighbor check
        for i in range(n-2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                candies[i] = max(candies[i], candies[i + 1] + 1)
            total += candies[i]

        return total