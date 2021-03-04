#Time Complexity :o(n)
#Space Complexity :o(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        if(len(ratings)==1):
            return 1
        
        n=len(ratings)
        candies=[1]*n
        
        #left Pass
        for i in range(1,n):
            if(ratings[i]>ratings[i-1]):
                candies[i]=candies[i-1]+1
        #right pass
        for i in range(n-2,-1,-1):
            if(ratings[i]>ratings[i+1]):
                candies[i]=max(candies[i],candies[i+1]+1)
        return sum(candies)
                
        
        