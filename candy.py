# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No
class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        give = [1] * n

        for i in range(1, n):
            if ratings[i] > ratings[i-1]:
                give[i] = give[i-1] + 1

        for i in range(n-2, -1, -1):
            if ratings[i] > ratings[i+1] and give[i] <= give[i+1]:
                give[i] = give[i+1] + 1

        return sum(give)