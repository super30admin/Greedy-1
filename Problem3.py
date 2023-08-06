#TIme complexity is O(n)
#Spacec omplexity is O(n)
#No issues faced while coding
#Code ran successfully on leetcode
class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        #base case
        if(ratings==None):
            return 0
        #initializing all the required variables
        n=len(ratings)
        result=[1 for i in range(n)]
        #forward pass
        for k in range(1,n):
            #If the ratings value at kth index is greater than k-1th index
            if(ratings[k]>ratings[k-1]):
                #We will update the value at index k as below
                result[k]=result[k-1]+1
        #Storing the sum value
        sum=result[n-1]
        #backward pass
        for g in range(n-2,-1,-1):
            #If the raings at g is greater than gi1th index value
            if(ratings[g]>ratings[g+1]):
                #We will take the maximum value of result[g] and result[g+1]+1
                result[g]=max(result[g],result[g+1]+1)
            #We will update the sum value
            sum+=result[g]
        #We are returning sum value
        return sum


