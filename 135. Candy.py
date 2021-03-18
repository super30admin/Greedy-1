'''
T = O(4n)
S = O(n)

Approach:
Perform a left pass and a right pass and update the no of candies.
'''

class Solution:
    def candy(self, ratings: List[int]) -> int:
        if ratings == None or len(ratings) == 0: return
        candies = [1] * len(ratings)
        
        for i in range(1,len(ratings)):
            if ratings[i] > ratings[i-1]:
                candies[i] = candies[i-1] + 1
                
        for i in range(len(ratings)-1,0,-1):
            if ratings[i-1] > ratings[i]:
                candies[i-1] = max(candies[i-1],candies[i]+1)
        
        return sum(candies)