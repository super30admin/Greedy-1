class Solution:
    def candy(self, ratings: List[int]) -> int:
        result = len(ratings)
        candies = [1] * len(ratings)
        
        for i in range(1,len(ratings)):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i-1] + 1
        
        for i in range(len(candies)-2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                candies[i] = max(candies[i], candies[i+1] + 1)
                
        
        return sum(candies)
    
    # TC: O(n) where n is the length of ratings
    # SC: O(n) because of the candies array