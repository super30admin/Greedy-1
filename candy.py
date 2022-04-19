# Time complexity: O(n)
# Space compleixty: O(2n)

class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        candies = []

        ##Left candies
        left_candies = []
        left_candies.append(1)
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                z = (left_candies[i - 1] + 1)
                left_candies.insert(i, z)
            else:
                left_candies.insert(i, 1)

        # Right_candies

        right_candies = [1] * (n)

        for j in range(n - 2, -1, -1):  ##(4,-1)
            if ratings[j] > ratings[j + 1]:
                right_candies[j] += right_candies[j + 1]

        for i, j in zip(right_candies, left_candies):
            candies.append(max(i, j))

        return sum(candies)

