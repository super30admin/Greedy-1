# Time Complexity: O(n)
# Space Complexity : O(n) for candies array
class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        # Initialize result array with one candy per person
        candies = [1 for _ in range(len(ratings))]
        
        # Scan ratings from left to right and increment candies if left neighbor has a higher rating than current child
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i-1]:
                candies[i] = candies[i-1] + 1
                
        # Scan from right to left and assign max(current or right neighbor + 1) candies to the current child
        for i in range(len(ratings)-2, -1, -1):
            if ratings[i] > ratings[i+1]:
                candies[i] = max(candies[i], candies[i+1]+1)
                
        # Return sum of candies array
        return sum(candies)