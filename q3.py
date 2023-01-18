# Time Complexity : O(n), Where n is number of elements in ratings List
# Space Complexity : O(n), Where n is number of elements in ratings List
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from typing import List
class Solution:
    def candy(self, ratings: List[int]) -> int:
        n=len(ratings)
        res=[1 for _ in range(n)]#This is temporary which is used get the final solution, Initially it has all the values set to 1, So that every get atleast one candy
        
        #Left neighbour check
        for i in range(1,n):
            if(ratings[i]>ratings[i-1]):
                res[i]=res[i-1]+1
        sol=res[n-1]
        #Right neighbour check
        for i in range(n-2,-1,-1):
            if(ratings[i]>ratings[i+1]):
                res[i]=max(res[i],1+res[i+1])
            sol+=res[i]
        return sol