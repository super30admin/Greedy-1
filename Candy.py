#TC:O(n)
#Sc:O(n)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        if ratings is None:
            return 0
        if len(ratings)==1:
            return 1
        ans = [1]*(len(ratings))
        ans_left = [1]*(len(ratings))
        ans_right = [1]*(len(ratings))
        for i in range(1,len(ratings)):
            if ratings[i]>ratings[i-1]:
                ans_left[i]=ans_left[i-1]+1
        
        for i in range(len(ratings)-2,-1,-1):
            if ratings[i]>ratings[i+1]:
                ans_right[i]=ans_right[i+1]+1
        for i in range(len(ratings)):
            ans[i]=max(ans_left[i],ans_right[i])
        return sum(ans)