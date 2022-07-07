'''
Time Complexity: 0(n)+0(n)
Space Complexity: 0(n)
Run on LeetCode: Yes
'''

class Solution:
    def candy(self, ratings: List[int]) -> int:
        
        # initlize a candies list
        candiesList = [1]*len(ratings) # given -- each child has atleast 1 candy
        
        '''
            if my current rating is grt than the previous rating, add 1 to my previous rating
            and store the maxima in-place
        '''
        
        # perform LHS pass
        for i in range(1,len(candiesList)):
            if ratings[i] > ratings[i-1]:
                candiesList[i] = max(candiesList[i],candiesList[i-1]+1)
        
        # perform RHS pass
        for i in range(len(candiesList)-2,-1,-1):
            if ratings[i] > ratings[i+1]:
                candiesList[i] = max(candiesList[i],candiesList[i+1]+1)
        
        # get the sum of candies list
        return sum(candiesList)