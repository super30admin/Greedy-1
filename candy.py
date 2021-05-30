# Time Complexity: O(n)
# Space Complexity: O(n)
# Ran on Leetcode: Yes

class Solution:
    def candy(self, ratings: List[int]) -> int:
        if not len(ratings):
            return 0
        n = len(ratings)
        out = [1] * n
        res = 0
        for i in range(1, n):
            if ratings[i-1] < ratings[i]:
                out[i] = out[i-1] + 1
        for i in range(n-2, -1, -1):
            if ratings[i+1] < ratings[i]:
                out[i] = max(out[i],out[i+1] + 1)
            res += out[i + 1]
        res += out[0]
        return res