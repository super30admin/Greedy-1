# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Greedy Approach. Initialize the candies array with 1 and having the length of ratings array
# Left pass  - Iterate over the ratings array from index + 1 and check if the current element is greater than the previous element
# If it is greater then update the current index in candies array by 1 greater than the previous element in candies
# Right pass - Iterate over the ratings array from second last index and check if the current element is greater than the next element
# If it is greater then update the current index in candies array by taking the maximum between current candies and next element in candies + 1
# Return sum of candies array
# Another Approach using up and down when the ratings increase we add up + 1 and when ratings decrease we add down + 1
# Initially set sum to len(ratings) that is n and i = 0 and while i < n we check if the ratings are equal we just increment i and coninue
# Initialize up to 0 and while ratings > previous ratings then we increment up by 1 and i by 1 and add up to sum
# Same for down if ratings < previous ratings then we increment down by 1 and i by 1 and add down to sum
# Then decrease sum by min(up,down)
# Return sum


class Solution:
    def candy(self, ratings: list[int]) -> int:
        n = len(ratings)
        result = [1] * n
        sum = 0
        for i in range(1, n):
            if ratings[i] > ratings[i-1]:
                result[i] = result[i-1] + 1
        sum = result[n-1]
        for i in range(n-2, -1, -1):
            if ratings[i] > ratings[i+1]:
                result[i] = max(result[i+1] + 1, result[i])
            sum += result[i]
        return sum
#2 Pass algorithm

class Solution:
    def candy(self, ratings: list[int]) -> int:
        n = len(ratings)
        sum = n
        i = 1
        while i < n:
            if ratings[i] == ratings[i-1]:
                i += 1
                continue
            up = 0
            while i < n and ratings[i] > ratings[i-1]:
                up += 1
                i += 1
                sum += up
            down = 0
            while i < n and ratings[i] < ratings[i-1]:
                down += 1
                i += 1
                sum += down
            sum -= min(up, down)
        return sum