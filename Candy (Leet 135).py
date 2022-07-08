class Solution:
    def candy(self, ratings: List[int]) -> int:
        
        if ratings is None or len(ratings) == 0:
            return 0
        
        
        res = [1 for _ in range(len(ratings))]
        
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i-1]:
                res[i] = res[i-1] + 1
        
        r = 0
        for i in range(len(ratings)-2,-1,-1):
            if ratings[i] > ratings[i+1]:
                res[i] = max(res[i],res[i+1]+1)
            r += res[i]
        
        r += res[-1]
        
        return r