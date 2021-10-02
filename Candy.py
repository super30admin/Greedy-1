"""
Time Complexity : O(n) where n is the number of elements in ratings array
Space Complexity : O(n) where n is the number of elements in ratings array
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def candy(self, ratings: List[int]) -> int:
        if len(ratings) == 0:
            return 0
        n = len(ratings)
        # Intializing candies array with 1 as all must have atleast 1 candies
        candies = [1]*n
        # Check for left neighbor
        for i in range(1, len(ratings), 1):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i - 1] + 1
        print(candies)
        # Check for right neighbor        
        sum1 = candies[-1]
        for i in range(n - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                candies[i] = max(candies[i], 1 + candies[i + 1])
            sum1 += candies[i]
        return sum1