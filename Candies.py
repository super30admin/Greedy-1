class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        candies = [1 for i in range(len(ratings))]
        for i in range(n):
            if i - 1 >= 0 and ratings[i] > ratings[i - 1]:
                candies[i] = max(candies[i - 1] + 1, candies[i])
            
            if n - i < n and ratings[n - i - 1] > ratings[n - i]:
                candies[n - i - 1] = max(candies[n - i] + 1, candies[n - i - 1])
            
        return sum(candies)


