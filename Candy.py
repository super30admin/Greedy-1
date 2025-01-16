# Approach:
# The key idea is to use a two-pass greedy approach to assign candies.
# 1. First, we perform a left-to-right pass: if ratings[i] > ratings[i-1], we give the child at index i one more candy than the child at index i-1.
# 2. Second, we perform a right-to-left pass: if ratings[i] > ratings[i+1], we make sure the child at index i has more candies than the child at index i+1, ensuring that both conditions are satisfied.
# During both passes, we update the candy counts accordingly. At the end, the total candy count will give us the minimum number of candies required.
# Time Complexity: O(n), where n is the number of children. We make two passes over the ratings array.
# Space Complexity: O(n), for the array to store the candy counts for each child.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        if n == 0:
            return 0
        
        # Step 1: Initialize the candies array, each child gets at least 1 candy initially
        candies = [1] * n
        
        # Step 2: Left-to-right pass
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i - 1] + 1
        
        # Step 3: Right-to-left pass
        for i in range(n - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                candies[i] = max(candies[i], candies[i + 1] + 1)
        
        # Step 4: The result is the sum of the candies array
        return sum(candies)
