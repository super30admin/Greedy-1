# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def candy(self, ratings):
        n = len(ratings)
        no_of_candies = [1] * n

        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                no_of_candies[i] = no_of_candies[i - 1] + 1

        for j in range(n - 2, -1, -1):
            if ratings[j] > ratings[j + 1] and no_of_candies[j] <= no_of_candies[j + 1]:
                no_of_candies[j] = no_of_candies[j + 1] + 1

        return sum(no_of_candies)


