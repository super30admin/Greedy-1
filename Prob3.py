class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        candy_dist = [1 for x in ratings]
        
        #left pass
        
        for i in xrange(1,len(ratings)):
            if ratings[i] > ratings[i-1]:
                candy_dist[i] = candy_dist[i-1] + 1
        
        #right pass
        
        for i in xrange(len(ratings)-2,-1,-1):
            if ratings[i] > ratings[i+1]:
                candy_dist[i] = max(candy_dist[i],candy_dist[i+1] + 1)
        
        return sum(candy_dist)
