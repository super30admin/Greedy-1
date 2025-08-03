from typing import List
# class Solution:
#     def candy(self, ratings: List[int]) -> int:
#         n = len(ratings)
#         candies = [1]*n
#         # left pass assign 1 if the rating[i]>rating[i-1]
#         for i in range(1,n):
#             if ratings[i]>ratings[i-1]:
#                 candies[i] = candies[i-1]+1
#         # right pass 
#         for i in range(n-2,-1,-1):
#             if ratings[i]>ratings[i+1]:
#                 candies[i] = max(candies[i], candies[i+1]+1)
#         return sum(candies)

class Solution:
    def candy(self, ratings: List[int]) -> int:
        candies,newslope, oldslope, n = 0,0,0,len(ratings)
        up, down = 0, 0
        def count(n):
            return (n*(n+1))//2
        for i in range(1,n):
            if ratings[i]>ratings[i-1]:
                newslope=1
            elif ratings[i]<ratings[i-1]:
                newslope=-1
            else:
                newslope = 0
            if (oldslope<0 and newslope>=0) or (newslope == 0 and oldslope>0):
                candies+=count(up)+count(down)+max(up,down)
                up,down=0,0
            if newslope==1:
                up+=1
            elif newslope==-1:
                down+=1
            else:
                candies+=1
            
            oldslope = newslope
        candies+=count(up)+count(down)+max(up,down)
        return candies+1
        
        