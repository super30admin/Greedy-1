# Time complexity : O(n)
# Space complexity : O(n)
# Leetcode : Solved and submitted

class Solution:
    def candy(self, ratings: List[int]) -> int:
        # null or empty case
        if not ratings or len(ratings) == 0:
            return 0
        # if there is just one rating, then return 1
        if len(ratings) == 1:
            return 1
        n = len(ratings)
        res = [1]*n
        
        # forward pass
        # in the forward pass, we compare the element with its left element, if greater than increment by 1
        for i in range(1,n):
            if ratings[i] > ratings[i-1]:
                res[i] = 1 + res[i-1]
        
        # backward pass
        # here we will check with left and right of the current element and then update it as the max
        val = res[n-1]
        for i in range(n-2,-1,-1):
            if ratings[i+1] < ratings[i]:
                res[i] = max(res[i],res[i+1]+1)
            # calculate the sum in this loop itself
            val += res[i]
        
        return val
