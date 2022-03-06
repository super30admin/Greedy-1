class Solution:
    
    # Greedy Approach
    # TC: O(N) --> 2N
    # SC: O(N) --> len candies used keep track of candies
    
    def candy(self, ratings: List[int]) -> int:
        
        n = len(ratings)
        
        candies = [1 for i in range(n)]
        result = 0
        
        # Forward Pass
        for i in range(1, n):
            if (ratings[i] > ratings[i-1]):
                candies[i] = candies[i-1] + 1
        
        # Backward Pass
        result += candies[-1]
        for i in range(n-2, -1, -1):
            if (ratings[i] > ratings[i+1]):
                candies[i] = max(candies[i], candies[i+1]+1)
            result += candies[i]
                
        return result