class Solution:
    def candy(self, ratings: List[int]) -> int:
        #Method 1 - 2 pass with an array
        #TC - O(2n) and O(n) SC
        n=len(ratings)
        res=[1 for _ in range(n)] #O(n) space
        for i in range(1,n): #left pass - move from left to right, and deal with left neighbours
            if ratings[i]>ratings[i-1]:
                res[i]=res[i-1]+1
         
        for i in reversed(range(n-1)):#right pass  - move from right to left, and deal with right neighbours
            if ratings[i]>ratings[i+1]:
                res[i]=max(res[i],res[i+1]+1)
        return sum(res)

            
