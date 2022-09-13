# TC: O(n)
# SC: O(n)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        if n == 1:
            return 1
        res = [1] * n
        # forward pass
        for i in range(1, n):
            if ratings[i] > ratings[i-1]:
                res[i] = 1 + res[i-1]
        total =  res[n-1]
        # backward pass
        for i in range(n-2, -1, -1):
            if ratings[i] > ratings[i+1]:
                res[i] = max(res[i], 1+res[i+1])
            total += res[i]
        
        return total