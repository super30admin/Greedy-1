#Time Complexity : O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def candy(self, ratings: List[int]) -> int:
        if not ratings:
            return 0

        n = len(ratings)
        candies = [1 for _ in range(n)]

        #left pass
        for i in range(1, n):
            if ratings[i-1] < ratings[i]:
                candies[i] = candies[i-1]+1

        #right pass
        for i in range(n-2, -1, -1):
            if ratings[i+1] < ratings[i]:
                candies[i] = max(candies[i+1]+1, candies[i])

        return sum(candies)
