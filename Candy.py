# Time Complexity : O(N) Two pass
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Greedy Approach. Initialize the candies array with 1 and having the length of ratings array
# Left pass  - Iterate over the ratings array from index + 1 and check if the current element is greater than the previous element
# If it is greater then update the current index in candies array by 1 greater than the previous element in candies
# Right pass - Iterate over the ratings array from second last index and check if the current element is greater than the next element
# If it is greater then update the current index in candies array by taking the maximum between current candies and next element in candies + 1
# Return sum of candies array


class Solution:
    def candy(self, ratings: List[int]) -> int:
        if not ratings:
            return 0
        candies = [1] * len(ratings)
        # left pass
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i - 1] + 1

        # right pass
        for i in range(len(ratings) - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                candies[i] = max(candies[i], candies[i + 1] + 1)

        return sum(candies)