"""
In first pass check left neighbor and increment candi count if rating if current idx is higher
In second pass check right neighbor and if rating of current index is higher increment candies count
take sum of candies at the end
TC: O(n)
SP:O(n)
"""
class Solution:
    def candy(self, ratings: List[int]) -> int:
        candies = [1] * len(ratings)
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i-1] +1
        for i in range(len(ratings) - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                candies[i] = max(candies[i], candies[i+1]+1)
        return sum(candies)
