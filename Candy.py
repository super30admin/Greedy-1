#  Time Complexity : O(N)   
#  Space Complexity : O(1)  
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english: This code solves the Candy problem by tracking increasing (up) and decreasing (down) slopes in the ratings array to determine how candies should be distributed. When the slope direction changes, it calculates the total candies for that hill/valley using the arithmetic sum formula n*(n+1)//2 and adjusts for the shared peak with max(up, down). Finally, it adds all calculated candies plus one (for the first child) and returns the minimum total required.

class Solution:
    def candy(self, ratings: List[int]) -> int:
        # TC: O(n)   SC: O(1)
        n = len(ratings)

        up = 0
        down = 0
        oldSlope = 0
        newSlope = 0
        candies = 0

        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                newSlope = 1
            elif ratings[i] < ratings[i - 1]:
                newSlope = -1
            else:
                newSlope = 0

            if (oldSlope < 0 and newSlope >= 0) or (oldSlope > 0 and newSlope == 0):
                candies += self.count(up) + self.count(down) + max(up, down)
                up = 0
                down = 0

            if newSlope == 1:
                up += 1
            elif newSlope == -1:
                down += 1
            else:
                candies += 1

            oldSlope = newSlope

        candies += self.count(up) + self.count(down) + max(up, down)

        return candies + 1

    def count(self, n):
        return n * (n + 1) // 2
