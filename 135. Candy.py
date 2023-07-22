#Time Complexity:O(n)
#Space complexity:O(n)

class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        if len(ratings)==0:
            return 0
        candy=[1]*len(ratings)
        for i in range(1,len(ratings)):
            if ratings[i]>ratings[i-1]:
                candy[i]=candy[i-1]+1
        for i in range(len(candy)-2,-1,-1):
            if ratings[i]>ratings[i+1]:
                candy[i]=max(candy[i],candy[i+1]+1)
        return sum(candy)