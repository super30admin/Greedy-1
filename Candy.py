#135. Candy
"""
Time Complexity : O(n)
Space Complexity : O(n)
"""
class Solution:
    def candy(self, ratings: List[int]) -> int:
        if len(ratings)<=1:
            return 1
        
        candies = [1]*len(ratings)
        
        #left to right
        for i in range(len(ratings)-1):
            if ratings[i]>ratings[i+1]:
                candies[i] = max(candies[i+1]+1, candies[i])
            elif ratings[i]<ratings[i+1]:
                candies[i+1] = max(candies[i+1], candies[i]+1)
        
        #right to left
        for i in range(len(ratings)-1,0,-1):
            if ratings[i]>ratings[i-1]:
                candies[i] = max(candies[i-1]+1, candies[i])
            elif ratings[i]<ratings[i-1]:
                candies[i-1] = max(candies[i-1], candies[i]+1)

        return (sum(candies))
