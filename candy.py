"""
Greedy approach -
TC : O(n)
SC: O(n)
Refer notes section for additional details
"""
class Solution:
    def candy(self, ratings: List[int]) -> int:
        if ratings is None or len(ratings) == 0: return 0

        n = len(ratings)
        rtnData = n * [1]
        # print(rtnData)
        total = 0

        # left to right pass
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                rtnData[i] = rtnData[i - 1] + 1

        total = rtnData[n - 1]
        # right to left pass
        for i in range(n - 2, -1, -1):
            # check right neighbor
            if ratings[i] > ratings[i + 1]:
                rtnData[i] = max(rtnData[i], rtnData[i + 1] + 1)
            total = total + rtnData[i]

        return total