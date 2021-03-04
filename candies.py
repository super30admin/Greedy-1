#Time Complexity -- O(n)
#Spacce O(n)

class Solution:
    def candy(self, ratings: List[int]) -> int:
        
        if not ratings:
            return []
        
        n = len(ratings)
        result = [1]*n
        
        #left passs
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i-1]:
                result[i] = result[i-1]+1
        
        #right pass
        for i in range(n-2, -1, -1):
            if ratings[i] > ratings[i+1]:
                result[i] = max(result[i+1]+1, result[i])
                
                
        return sum(result)
        
        
