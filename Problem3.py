# Problem 3: Candy
class Solution:
    def candy(self, ratings: List[int]) -> int:
        Sum = 0
        n = len(ratings)
        result = [1 for _ in range(n)]

        for i in range(1,n):
            if ratings[i-1] < ratings[i]:
                result[i] = result[i-1] +  1

        for i in range(n-2,-1,-1):
            if ratings[i] > ratings[i+1]:
                result[i] = max(result[i],result[i+1]+1)

            Sum += result[i+1]
        
        Sum += result[0]

        print(result)

        return Sum