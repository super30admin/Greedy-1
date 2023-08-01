# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
"""
The code first assigns one candy to each of the children and checks with the left neighbour if one more candy is required to be given to each 
children to agree with the rules. The same is also done by looking at the right neighbour.
"""

class Solution:
    def candy(self, ratings: List[int]) -> int:
        if ratings == None or len(ratings) == 0: return 0

        candies = [1 for i in range(len(ratings))]

        # Check with left neighbour
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i-1]:
                candies[i] = candies[i-1] + 1

        total = candies[-1]
        # Check with the right neighbour
        for i in range(len(ratings) - 2, -1, -1):
            if ratings[i] > ratings[i+1]:
                candies[i] = max(candies[i],candies[i+1] + 1)
            total = total + candies[i]
        return total