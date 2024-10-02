# Time complexity = O(n)
# Space Complexity - O(n)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        res = [1] * n
        for i in range(1,n):
            if ratings[i] > ratings[i-1]:
                res[i] = res[i-1] + 1
        candies = res[n-1]
        for i in range(n-2,-1,-1):
            if ratings[i] > ratings[i+1]:
                res[i] = max(res[i],res[i+1] + 1) # max because after first pass we need to check at max of both neightbors ex - 8 10 9 -> 10 should have more candies than 8 and 9
            candies += res[i]
        return candies




# Time complexity = O(n)
# Space Complexity - O(1)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        prev_slope = 0
        cur_slope = 0
        candies = 1
        up = down = 0
        for i in range(1,len(ratings)):
            if ratings[i-1] > ratings[i]:
                cur_slope = -1
            elif ratings[i-1] < ratings[i]:
                cur_slope = 1
            else: cur_slope = 0
            # compute arithmetic progression n*(n+1)//2 everytime slope changes
            if (prev_slope > 0 and cur_slope == 0) or (prev_slope < 0 and cur_slope >= 0):
                candies += (up *(up+1))//2 + (down *(down+1))//2 + max(up,down)
                up = down = 0

            if cur_slope > 0: up += 1
            elif cur_slope < 0: down += 1
            else: candies += 1 # For constant slope just add 1 candy as default
            prev_slope = cur_slope
        candies += (up *(up+1))//2 + (down *(down+1))//2 + max(up,down)
        return candies
