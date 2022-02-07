class Solution:
    def candy(self, ratings: List[int]) -> int:
        if len(ratings) == None: return 0 
        n = len(ratings)
        candies = [1 for l in range(0, n)]
        # // Left pass
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i - 1] + 1
        sum = candies[n - 1]    
        for i in range( n - 2, -1, -1 ):
            if ratings[i] > ratings[i + 1 ]:
                candies[i] = max(candies[i], candies[i + 1] + 1)
            sum += candies[i]
        return sum
    
# T.C => O(N)
# S.C => O(candies)
# Approach => 1. First create array ofsize candies with initializing 1 candies to each of the children
# 2. Here do a left pass first  start from index 1 and check its left it its smaller then the current cand must be updated with plus one then the previous candy.
# 3. Do the right pass and start that from n - 2. If the next neighbour(right side) has less ratings and current children has same number of candy then increment its current value then the next neighbour.
# 4. At the end calculate sum first by getting sum of last index then all the childrens sums, return that sum