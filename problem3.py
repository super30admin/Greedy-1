#Time , space O(n)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        candies=[1]*len(ratings)
     #Left traversal
        for i in range(1,len(ratings)):
            if ratings[i]>ratings[i-1]:
                candies[i]=candies[i-1]+1
        total = candies[len(candies)-1]     

        #Right traversal
        for i in range(len(ratings)-2,-1,-1):
            if ratings[i]>ratings[i+1]:
                candies[i]=max(candies[i],candies[i+1]+1)
            total+=candies[i]
            
        return total
