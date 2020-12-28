# as taught in class, using greedy technique to solve this problem.Start distributing cndies from left to right check with previous if less than current then add 1 more than previous. 
#Time complexity: o(n)
#Space complexity: O(1)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        if len(ratings) == 0 or ratings is None:
            return 0
        candy = [1]*len(ratings)
        for i in range(len(ratings)):
            if ratings[i] > ratings[i-1]:
                candy[i] = candy[i-1] + 1
        for i in range(len(ratings)-2,-1,-1):
            if ratings[i] > ratings[i+1]:
                candy[i] = max(candy[i],candy[i+1] + 1)
        sum = 0
        for num in candy:
            sum = sum + num
        return sum