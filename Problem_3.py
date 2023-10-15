"""
Problem : 3

Time Complexity : O(n)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


"""

# Candy

class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        if not ratings:
            return 0
        n=len(ratings)
        result=[1 for _ in range(n)]

        # forward pass
        for i in range(1,n):
            if ratings[i]>ratings[i-1]:
                result[i]=result[i-1]+1
        # backward pass
        summ=result[n-1]
        for i in range(n-2,-1,-1):
            if ratings[i]>ratings[i+1]:
                result[i]=max(result[i],result[i+1]+1)
            summ+=result[i]
        return summ