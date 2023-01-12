'''
Time Complexity --> O(n)
Space Complexity --> O(n)

We can use a greedy approach to this problem
'''
class Solution:
    def candy(self, ratings: List[int]) -> int:
        res = [1 for x in range(len(ratings))]
        #left neighbour check
        for i in range(1, len(ratings)):
            if ratings[i]>ratings[i-1]:
                res[i] = res[i-1]+1
        #rigth neigbour check
        tot = res[-1]
        for j in range(len(ratings)-2, -1, -1):
            if ratings[j]>ratings[j+1]:
                res[j] = max(res[j], res[j+1]+1)
            tot+=res[j]
        return(tot)
        