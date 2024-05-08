'''
TC: O(n) - in real it is O(2n) ~ O(n) since we do two passes
            L->R and R->L
SC: O(n) - since we keep an array for keeping track of max candies given

Performing a greedy approach
'''
from typing import List

class Solution:
    def candy(self, ratings: List[int]) -> int:
        res = [1]*len(ratings)
        # L->R
        for i in range(1,len(ratings)):
            if ratings[i]>ratings[i-1]:
                res[i] = res[i-1]+1
        sum_ = res[-1]
        # R->L
        for i in range(len(ratings)-2,-1,-1):
            if ratings[i]>ratings[i+1]:
                res[i] = max(res[i],res[i+1]+1)
            sum_ += res[i]
        return sum_
s = Solution()
print(s.candy([8,5,4,1,0,4,5,7,2,1,5,4,3,3,8]))
print(s.candy([1,2,2]))
print(s.candy([1,0,2]))