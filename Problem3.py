# In this approach, we use a greedy approach to assign candies to children based on their ratings.
# We iterate through the ratings array twice: first from left to right and then from right to left.
# Time Complexity: O(N)
# Space Complexity: O(N)


class Solution:
    def candy(self, ratings: List[int]) -> int:
        if not ratings:
            return 0
        res = [1] * len(ratings)
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i - 1]:
                res[i] = res[i - 1] + 1
        for i in range(len(ratings) - 2, -1, -1):
            if ratings[i + 1] < ratings[i]:
                res[i] = max(res[i], res[i + 1] + 1)
        return sum(res)