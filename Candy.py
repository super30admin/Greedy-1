class Solution:
    def candy(self, ratings: List[int]) -> int:
        if len(ratings) == 0:
            return 0
        n = len(ratings)
        candy = [1]*n
        # check rating of each child with left neighbour
        for i in range(1, n):
            if ratings[i-1]< ratings[i]:
                candy[i] = candy[i-1] +1

        # check rating of each child with right neighbour
        sum1 = candy[n-1]
        for i in range(n-2, -1, -1):
            if ratings[i] > ratings[i+1]:
                candy[i] = max(candy[i], candy[i+1] +1)
            sum1 = sum1 + candy[i]
        return sum1
    # TC : O(n)
    # Sc : O(n)