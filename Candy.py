"""
Approach: Using one array

We will make use of a single array candies to keep the count of the number of candies to be allocated to the current student. 

In order to do so, firstly we assign 1 candy to each student. 

Then, we traverse the array from left-to-right and distribute the candies following only the left neighbor relation i.e. whenever the current element's ratings is larger than the left neighbor and has less than or equal candies than its left neighbor, we update the current element's candies in the candies array as candies[i] = candies[i-1] + 1. 

While updating we need not compare candies[i] and candies[i - 1], since candies[i] <= candies[i - 1] before updating. 

After this, we traverse the array from right-to-left. Now, we need to update the i'th element's candies in order to satisfy both the left neighbor and the right neighbor relation. Now, during the backward traversal, if ratings[i] > ratings[i + 1], considering only the right neighbor criteria, we could've updated candies[i] as candies[i] = candies[i + 1] + 1. But, this time we need to update candies[i] only if candies[i] <= candies[i + 1]. This happens because this time we've already altered the candies array during the forward traversal and thus candies[i] isn't necessarily less than or equal to candies[i + 1]. Thus, if ratings[i] > ratings[i + 1], we can update candies[i] as candies[i] = max(candies[i], candies[i + 1] + 1), which makes candies[i] satisfy both the left neighbor and the right neighbor criteria.

Again, we need to sum up all the elements of the candies array to obtain the required result.

TC: O(n)
SC: O(n)
"""
class Solution:
    def candy(self, ratings: List[int]) -> int:
        if ratings == None or len(ratings) == 0:
            return 0
        
        n = len(ratings)
        candies = [1] * n
        
        # Left to right
        for i in range(1, n):
            if ratings[i] > ratings[i-1]:
                candies[i] = candies[i-1] + 1
                
        # Right to left
        for i in range(n-2, -1,-1):
            if ratings[i] > ratings[i+1]:
                candies[i] = max(candies[i], candies[i+1] + 1)
                
        return sum(candies)
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        