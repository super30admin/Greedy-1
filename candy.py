# TC:O(N^2)
# SC:O(N)

class Solution:
    def candy(self, ratings: List[int]) -> int:

        N=len(ratings)
        o=[1 for _ in range(N)]


        for i in range(1,N):
            if ratings[i]>ratings[i-1]:
                o[i]=max(o[i-1]+1,o[i])

        
        for i in range(N-2,-1,-1):
            if ratings[i]>ratings[i+1]:
                o[i]=max(o[i+1]+1,o[i])

        return sum(o)