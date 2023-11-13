#TC:O(N) SC:O(N)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        arr=[1]*len(ratings)
        
        for i in range(1,len(ratings)):
            if ratings[i]>ratings[i-1]:
                arr[i]=arr[i-1]+1
       
        for i in reversed(range(len(ratings)-1)):
            if ratings[i]>ratings[i+1]:
                arr[i]=max(arr[i],arr[i+1]+1)

        return sum(arr)
