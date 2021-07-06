class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        if ratings is None or n == 0:
            return None
        candies = [1]*n
        for i in range(1, n):
            if ratings[i] > ratings[i-1]:
                candies[i] = candies[i-1]+1
        for i in range(n-2, -1, -1):
            if ratings[i] > ratings[i+1]:
                candies[i] = max(candies[i], candies[i+1]+1)
        tot_sum = 0
        for i in range(n):
            tot_sum += candies[i]
        return tot_sum
