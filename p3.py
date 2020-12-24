#time: O(n)
#Space: O(1)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        
        if ratings is None or len(ratings)==0:
            return 0
        
        candies = [1]*len(ratings)
        
        n = len(ratings)
        
        for i in range(1,n):
            if ratings[i-1] < ratings [i]:
                candies[i] = candies[i-1]+1
        
        for i in reversed(range(n-1)):
            if ratings[i] > ratings[i+1]:
                candies[i] = max(candies[i],candies[i+1]+1)
        
        
        return sum(candies)
            
        
