#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        lst = [1]*(len(ratings))
        n = len(ratings)
        for i in range(1,len(ratings)):
            if ratings[i] > ratings[i-1]:
                lst[i] = lst[i-1] + 1
                
        total = lst[n-1]  
        for i in range(n-2,-1,-1):
            if ratings[i] > ratings[i+1]:
                lst[i] = max(lst[i],lst[i+1]+1)
            total += lst[i]
               
        return total