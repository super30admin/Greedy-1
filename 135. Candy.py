#time: O(n)
#space: O(1)
class Solution:
    def candy(self, ratings: List[int]) -> int:

        n= len(ratings)
        #dp array
        candy= [1]*n

        # we will doing 2 passes of traversal for comparing current element with left and then second one for comparing current with right
        for i in range(1,n):
            if ratings[i] > ratings[i-1]:
                candy[i] = max(candy[i], candy[i-1]+1)
        total=candy[-1]
        for i in range(n-2,-1,-1):
            if ratings[i] > ratings[i+1]:
                candy[i] = max(candy[i], candy[i+1]+1)
            total += candy[i]
        
        return total
