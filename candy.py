# Time complexity - O(n)
#  Space complexity - O(n)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        if len(ratings) == 0:
            return 0
        res=[1]*len(ratings)
        n=len(ratings)
        for i in range(1,n):
            if(ratings[i]>ratings[i-1]):
                res[i]=res[i-1]+1
        s=res[n-1]
        for i in range(n-2,-1,-1):
            if ratings[i]>ratings[i+1]:
                res[i]=max(res[i],res[i+1]+1)
            s+=res[i]
        return s
        