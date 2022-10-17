# TC: O(n)
# SC: O(n)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        if not ratings:
            return ""
        if len(ratings) == 1:
            return 1
#         min_candy = len(ratings)
        
#         last = 1
#         if ratings[0] > ratings[1]:
#             min_candy += 1
#             last += 1
#         for i in range(1,len(ratings)-1):
#             if ratings[i] > ratings[i-1] or ratings[i] > ratings[i+1]:
#                 min_candy += last
#                 last += 1
#             else:
#                 last = 1
#         if ratings[len(ratings)-1] > ratings[len(ratings)-2]:
#             min_candy += last
        
        candies = [1]*len(ratings)
        for i in range(1,len(ratings)):
            if ratings[i] > ratings[i-1]:
                candies[i] = candies[i-1] + 1
        for i in reversed(range(len(ratings)-1)):
            if ratings[i] > ratings[i+1]:
                candies[i] = max(candies[i],candies[i+1]+1)
            
        return sum(candies)