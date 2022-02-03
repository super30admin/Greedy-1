# Time Complexity : O(n)
# Space Complexity:o(1)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def candy(self, ratings: List[int]) -> int:
        candyArr = [1] * (len(ratings))

        for i in range(1, len(candyArr)):
            if ratings[i] > ratings[i - 1]:
                candyArr[i] = candyArr[i - 1] + 1

        sum = candyArr[-1]
        for i in range(len(candyArr) - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                candyArr[i] = max(candyArr[i], candyArr[i + 1] + 1)
            sum += candyArr[i]
        print(candyArr)
        return sum

