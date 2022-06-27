class Solution:
    def candy(self, ratings: List[int]) -> int:
        ans = [1 for i in range(len(ratings))]
        
        i = 1
        while(i<len(ratings)):
            if(ratings[i-1]<ratings[i]):
                ans[i]= ans[i-1]+1
            
            i+=1
        i-=2
        while(i>=0):
            if(ratings[i] >ratings[i+1]):
                ans[i]= max(ans[i+1]+1,ans[i])
            i-=1
        return sum(ans)