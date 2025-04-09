# Problem 3 : Candy
# Time Complexity : O(n) where n is the size of the ratings list
# Space Complexity : O(n) where n is the size of the ratings list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def candy(self, ratings: List[int]) -> int:
        # get the length of the ratings
        length = len(ratings)
        # define result array with the length of ratings and fill with 1
        result = [1] * length

        # loop from 1 to length
        for i in range(1, length):
            # if the value at ith position is greater than the (i-1)th posiition
            if ratings[i] > ratings[i-1]:
                # if it is then set the value at ith position as 1 + value at (i-1)th position
                result[i] = 1 + result[i-1]
        # define total variable and set the value as result[-1]
        total = result[-1]
        # loop from from length-2 to 1
        for i in range(length-2, -1, -1):
            # if the value at ith position is greater than (i+1)th position
            if ratings[i] > ratings[i+1]:
                # the value of result at ith position is maximum of value at ith position and (1+ value at (i+1)th position)
                result[i] = max(result[i], result[i+1] + 1)
            # update the total by adding the value at ith position
            total += result[i]
        # return total 
        return total