# Time Complexity : O(n)
# Space Complexity : O(n)
# The code ran on Leetcode
# Make two passes. One from front and the other from end. Update the number of candies if the current rating is more than the rating of the neighbor
class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        dp = [1]*n

        for i in range(1, n):
            if ratings[i] > ratings[i-1] and dp[i] <= dp[i-1]:
                dp[i] = dp[i-1] + 1

        for i in range(n-2, -1, -1):
            if ratings[i] > ratings[i+1] and dp[i] <= dp[i+1]:
                dp[i] = dp[i+1] + 1
        return sum(dp)