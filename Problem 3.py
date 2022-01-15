# Time: O(n)
# Space: O(n)
class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        candies = [1]* len(ratings)
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i-1]:
                candies[i] = candies[i-1] + 1
        #print(candies)
        for i in range(len(ratings)-2, -1, -1):
            if ratings[i] > ratings[i+1]:
                candies[i] = max(candies[i],candies[i+1]+1)
        #print(candies)
        return sum(candies)
