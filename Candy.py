# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def candy(self, ratings: List[int]) -> int:
        if(ratings == None or len(ratings) == 0):
            return 0
        
        n = len(ratings)
        result = [1]*n

        for i in range(1, n):
            if(ratings[i]>ratings[i-1]):
                result[i] = result[i-1]+1
        
        sum = result[n-1]

        for i in range(n-2, -1, -1):
            if(ratings[i]>ratings[i+1]):
                result[i] = max(result[i], result[i+1]+1)
            sum+=result[i]
        
        return sum
    
sc = Solution()
ratings = [1,0,2]
print(sc.candy(ratings))