""""// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def candy(self, ratings: List[int]) -> int:
        candiesList = [1]*len(ratings)
        n=len(candiesList)

        # perform forward pass
        for i in range(1,n):
            if ratings[i] > ratings[i-1]:
                candiesList[i] = candiesList[i-1]+1

        # perform backward pass
        for i in range(n-2,-1,-1):
            if ratings[i] > ratings[i+1]:
                candiesList[i] = max(candiesList[i],candiesList[i+1]+1)

        # get the sum of candies list
        return sum(candiesList)