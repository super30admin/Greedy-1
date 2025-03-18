#Time = O(n)
#Space = O(n)

class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        #first give everyone one candy
        candies = [1]* n
       #if curr rating is large than its left add left candies + 1
        for i in range(1,n):
            if ratings[i] > ratings[i-1]:
                candies[i] = candies[i-1]+1
        sum = candies[-1]  
        #if curr rating is large than its right keep maximum between(right candies + 1 , curr candies)
        for i in range(n-2,-1,-1):   
            if ratings[i] > ratings[i+1]:
                candies[i] = max(candies[i],candies[i+1]+1)
            sum += candies[i]
        return sum