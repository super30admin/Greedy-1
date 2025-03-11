class Solution:
    
    # TC: O(n)
    # SC: O(n)
    def candy(self, ratings: List[int]) -> int:
        if ratings is None:
            return 0
        n = len(ratings)
        res = [1]*n
        # check rating of each child with left neighbour
        for i in range(1,n):
            if ratings[i] > ratings[i-1]:
                res[i] = res[i-1]+1
        # check rating of each child with right neighbour
        sumv = res[n-1]
        for i in range(n-2,-1,-1):
            if ratings[i] > ratings[i+1]:
                res[i] = max(res[i],res[i+1]+1)
            sumv += res[i]
        return sumv
            
        