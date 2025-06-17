'''
    Time Complexity: O(n)
    Space Complexity: O(n)
'''
class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        candies = [1 for _ in range(n)]

        for i in range(1, n):
            if ratings[i] > ratings[i-1] and candies[i] <= candies[i-1]:
                candies[i] = candies[i-1] + 1

        result = candies[n-1]
        for j in range(n-2, -1, -1):
            if ratings[j] > ratings[j+1] and candies[j] <= candies[j+1]:
                candies[j] = candies[j+1] + 1
            result += candies[j]

        return result