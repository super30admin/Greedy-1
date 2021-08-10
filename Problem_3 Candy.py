# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def candy(self, ratings: List[int]) -> int:
        if not ratings:
            return 0
        n = len(ratings)
        #Distrubute 1 candy to each initially
        candy = [1] * n
        # left to right
        for i in range(1, n):
            #Check if curr rating is graeter than neighbors rating, increment the candies accordinly
            if ratings[i - 1] < ratings[i]:
                candy[i] = candy[i - 1] + 1

        # right to left
        for i in range(n - 2, -1, -1):
            # Check if curr rating is greater than neighbors rating, increment the candies accordinly
            if ratings[i + 1] < ratings[i]:
                candy[i] = max(candy[i], candy[i + 1] + 1)
        return sum(candy)