#Time: O(n)
#Space: O(1)
#Program ran on leetcode successfully

class Solution:
    def candy(self, ratings: List[int]) -> int:
        candies = [1] * len(ratings)
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i-1]:
                candies[i] = candies[i-1] + 1
            
        sumCandies = candies[-1]
        
        for i in reversed(range(len(ratings)-1)):
            if ratings[i] > ratings[i+1]:
                candies[i] = max(candies[i], candies[i+1] + 1)
            sumCandies += candies[i]
        
        return sumCandies
        