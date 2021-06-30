from typing import List

# O(n) for S ad T
class Solution:
    def candy(self, ratings: List[int]) -> int:
        if ratings is None or len(ratings) == 0: return -1
        candyarray = [1] * len(ratings)

        # left pass

        for child in range(1, len(ratings)):
            if ratings[child] > ratings[child - 1]:
                candyarray[child] = candyarray[child - 1] + 1

        # right pass
        for child in range(len(ratings) - 2, -1, -1):
            if ratings[child] > ratings[child + 1]:
                candyarray[child] = max(candyarray[child + 1] + 1, candyarray[child])

        # total candies

        total_candy = 0
        for candy in candyarray:
            total_candy += candy

        return total_candy

# ratings = [1,0,2]
# print(Solution().candy( ratings=ratings))



