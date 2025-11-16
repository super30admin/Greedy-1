class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        # single pass greedy algo 
        # total candies = len of ratings + len of the peaks 
        # lets take an example [1,2,3,4,5] for 1 1 candi, 2 needs 1+ 1 more as its higher 2 candies , now 3 we can't simply give 1+1 because its neighbor 2 also have 2 candies , thsi should have ore than 2 so 3 candies 
        # so we need the len of the slope at that point, the peaks can be as upward or downward also 
        # when we are keep moving upward we need to add those many extra candies, same as down then w need to add those many extra candies 
        # also if our downhill> peak( the upwrd slope) that means the before child should have gotten an extra candy such that the neighbor can have more candies than this
        # [2,4,3,2,1] intially for [2,4] we give 2 candies, 1 for each but when 2,4,3 has come 4 should have had 2 candies and 3 have 1 so when ever the down hill is greate than peak we should increase our candy count by 1 

        # tc : O(n) , sc : O(1)

        n = len(ratings)
        if n <= 1:
            return n

        total = 1      # total candies so far (first child setting with 1
        up = 1         # length of current up-slope (counts the first in the slope)
        down = 0       # length of current down-slope
        peak = 1       # candies at the peak (height from last up-slope)

        for i in range(1, n):
            if ratings[i] > ratings[i-1]:
                up += 1
                peak = up
                down = 0
                total += up # extra up number of candies 

            elif ratings[i] == ratings[i-1]: # reset everything back and 1 candy for this 
                up = 1
                down = 0
                peak = 1
                total += 1

            else:  # ratings[i] < ratings[i-1]
                down += 1
                up = 1
                total += down # extra down number of candies 
                if down >= peak: 
                    total += 1

        return total