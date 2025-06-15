# Time Complexity : O(n)
# Space Complexity : O(1)
class Solution:
    def candy(self, ratings):
        def count(n):
            return n * (n+1) // 2

        n = len(ratings)
        up, down = 0, 0
        oldSlope, newSlope = 0, 0
        candies = 0

        for i in range(1, n):
            if ratings[i] > ratings[i-1]:
                newSlope = 1
            elif ratings[i] < ratings[i-1]:
                newSlope = -1
            else:
                newSlope = 0

            if (oldSlope < 0 and newSlope >= 0) or (oldSlope > 0 and newSlope == 0):
                candies += count(up) + count(down) + max(up, down)
                up = 0
                down = 0

            if newSlope > 0:
                up += 1
            elif newSlope < 0:
                down += 1
            else:
                candies += 1
            
            oldSlope = newSlope

        candies += count(up) + count(down) + max(up, down)
        return 1+candies

# Time Complexity: O(3n)
# Space Complexity: O(1)
class Solution:
    def candy(self, ratings):
        n = len(ratings)
        res = [1] * n
        candies = 0

        for i in range(1, n):
            if ratings[i] > ratings[i-1]:
                res[i] = res[i-1] + 1
        
        for j in range(n-2, -1, -1):
            if ratings[j] > ratings[j+1]:
                res[j] = max(res[j], res[j+1]+1)
        
        for k in range(n):
            candies += res[k]
        return candies