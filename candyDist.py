class Solution:
    
    """
    Description: distribute candies based on a ratings array, each child must get one candy and children with higher rating then their neighbor should have more candies than them
    
    Time Complexity: O(n)
    Space Complexity: O(n)
    
    Approach: 2 pass solution
    - create an array with all 1s (1 candy for each child)
    - for left pass, add one more candy if rating is higher than child on the left
    - for right pass, add candy if the child on left don't have higher candies than the right neighbor + 1
    - return the sum of resulting array
    """
    
    def candy(self, ratings: List[int]) -> int:
    
        if ratings == None or len(ratings) == 0: return
        
        candies = [1]*len(ratings)
        # left pass
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i - 1] + 1
                
        # right pass
        for i in range(len(ratings) - 1, 0, -1):
            if ratings[i - 1] > ratings[i]:
                candies[i - 1] = max(candies[i - 1], candies[i] + 1)
                
        return sum(candies)
