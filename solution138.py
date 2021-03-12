class Solution:
    def candy(self, ratings: List[int]) -> int:
        if len(ratings)==0:
            return 0
        candies=[1 for i in range(len(ratings))]
        for i in range(1,len(ratings)):
            if ratings[i]>ratings[i-1]:
                candies[i]=candies[i-1]+1
        for i in reversed(range(len(ratings)-1)):
            if ratings[i]>ratings[i+1]:
                candies[i]=max(candies[i],candies[i+1]+1)
        count=0
        for elem in candies:
            count+=elem
        return count