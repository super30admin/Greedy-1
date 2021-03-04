class Solution:
    #Solution 1
    def candy(self, ratings: List[int]) -> int:
        #Approach: Two-pass // Greedy
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        #where, n is the length of nums
        
        candies = [1 for _ in ratings]
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i - 1] + 1
        
        for i in reversed(range(0, len(ratings) - 1)):
            if ratings[i] > ratings[i + 1]:
                candies[i] = max(candies[i], candies[i + 1] + 1)
                
        return sum(candies)
    
    #Solution 2
    """
    def candy(self, ratings: List[int]) -> int:
        #Approach: Brute force, n-passes
        #Time Complexity: O(n^2)
        #Space Complexity: O(n)
        #where, n is the length of nums
        
        n = len(ratings)
        flag = True     #whether the next iteration is required
        candies = [1 for _ in range(n)]
        
        
        while flag:
            flag = False
            
            for i in range(n):
                if i > 0 and ratings[i] > ratings[i - 1] and candies[i] <= candies[i - 1]:
                    candies[i] = candies[i - 1] + 1
                    flag = True
                    
                if i + 1 < n and ratings[i] > ratings[i + 1] and candies[i] <= candies[i + 1]:
                    candies[i] = candies[i + 1] + 1
                    flag = True
                    
        return sum(candies)
    """