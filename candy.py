
#Time Complexity : O(n)
#Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def candy(self, ratings: List[int]) -> int:
        res = [1]*len(ratings)
        for i in range(1, len(ratings)):
            if ratings[i-1] < ratings[i]:
                    res[i] = res[i-1] + 1
        sumv = 0
        print(res)
        for i in range(len(ratings)-1, 0, -1):
            if ratings[i] < ratings[i-1]:
                    res[i-1] = max(res[i-1], res[i]+1)
            sumv += res[i]
        print(res)
        sumv += res[0]
        return sumv