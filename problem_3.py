# TC - O(n)
# SC - O(n)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        res = [1] * n
        for i in range(1, n):
           if ratings[i] > ratings[i-1]:
               res[i] = res[i-1] + 1 
        
        total = res[n-1]

        for i in range(n-2, -1, -1):
           if ratings[i] > ratings[i+1]:
               res[i] = max(res[i],res[i+1] + 1 ) 
            
           total += res[i]

        print(res)

        return total
