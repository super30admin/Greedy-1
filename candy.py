# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I go from first index to last index and chek if value at previous index is greater, I increment candies by one. Then I go from second to last to first index
# I increment if the element at the next index is less and has more candies.

class Solution:
    def candy(self, ratings: List[int]) -> int:
        candies = [1]*len(ratings)
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i-1]:
                candies[i] = candies[i-1] + 1
               
        for i in range(len(ratings)-2, -1, -1):
            if ratings[i] > ratings[i+1] and candies[i] <= candies[i+1]:
                candies[i] = candies[i+1] + 1
                
        return sum(candies)
