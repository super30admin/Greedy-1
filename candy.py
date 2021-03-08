  
  
  def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        candies = [1] * n  # Start with 1 candy for each child
                
        for i in range(1,n):       # First Pass: Check child to left, moving left to right
            if ratings[i] > ratings[i-1]:
                candies[i] = candies[i-1] + 1
        
        for i in range(n-2,-1,-1): # Second Pass: Check child to right, moving right to left
            if ratings[i] > ratings[i+1] and candies[i] <= candies[i+1]: 
                candies[i] = candies[i+1] + 1    
            
        return sum(candies)