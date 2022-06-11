#candy

# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no




class Solution:
    def candy(self, ratings: List[int]) -> int:
        array=[1]*len(ratings)
        res=0
        for i in range(1, len(ratings)):                    #first, loop and check if the left values  are less, it they are increment the value of the current index
            if(ratings[i]>ratings[i-1]):
                array[i] = array[i-1]+1
        
        res+=array[-1]
        for i in range(len(ratings)-2, -1,-1):              #then, loop again from the rightside, if the value is greater than the right one, then the current value should be the max between current or one more than the right one
            if(ratings[i]>ratings[i+1]):
                array[i] = max(array[i],array[i+1]+1)
            res+=array[i]

        return res
        