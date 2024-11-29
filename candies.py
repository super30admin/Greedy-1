# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach

class Solution:
    def candy(self, ratings: List[int]) -> int:
        candies=[1 for i in range(len(ratings))]
        for i in range(1,len(ratings)):
            if ratings[i]>ratings[i-1]:
                candies[i]=candies[i-1]+1
        summ=candies[len(ratings)-1]
        for i in range(len(ratings)-2,-1,-1):
            if ratings[i]>ratings[i+1]:
                candies[i]=max(candies[i],candies[i+1]+1)
            summ+=candies[i]
        return summ