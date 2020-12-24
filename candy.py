"""

TC=O(N)
SC=0(N)


-All the child gets 1 candy
- First pass compares the prev aand curr rating and increase plus 1
-second pass is backward comparing curr and next and increase plus 1 
"""


class Solution:
    def candy(self, ratings: List[int]) -> int:
        if not ratings:
            return 0
        
        n=len(ratings)
        candies=[1]*n
        #left pass frontword
        for i in range(1,n):
            if(ratings[i-1]<ratings[i]):
                candies[i]=candies[i-1]+1
        
        #right pass backward
        for i in range(n-2,-1,-1):
            if(ratings[i+1]<ratings[i]):
                candies[i]=max(candies[i+1]+1,candies[i])
                
        return sum(candies)