class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        #O(n)
        #O(n)
        #each child gets atleast 1 candy for sure
        res=[1]*len(ratings)
        #traverse from left and trace left neighbour then update the candy value
        for i in range(1,len(ratings)):
            if ratings[i]>ratings[i-1]:
                res[i]=res[i-1]+1
        #traverse from right and trace neighbour then update the candy value as max of already present value and right neighbour
        #max as we need to see with respect to both neighbours
        for i in range(len(ratings)-2,-1,-1):
            if ratings[i]>ratings[i+1]:
                res[i]=max(res[i],res[i+1]+1)
        #count total no. of candies
        total=0
        for i in res:
            total+=i
        return total
            