# 135. Candy
# https://leetcode.com/problems/candy/

# Logic: We iterate over the input and if the element is more 
# than previous element, we increase the its value in the candies
# array. The we iterate from the end and do the same thing. We 
# return the sum of candies.

# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        
        if n == 0:
            return 0
        
        candies = [1 for _ in range(n)]
        
        # Left to right traversal - update candies for the element with more value
        for i in range(1, n):
            if ratings[i] > ratings[i-1]:
                candies[i] = candies[i-1] + 1
        
        # Right to left traversal
        for i in range(n-2, -1, -1):
            if ratings[i] > ratings[i+1]:
                candies[i] = max(candies[i], candies[i+1] + 1)
        
        return sum(candies)