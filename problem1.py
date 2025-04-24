#  https://leetcode.com/problems/candy/

class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        i = 1
        ans = 1

        while i < n:
            if ratings[i-1] == ratings[i]:
                ans+=1
                i+=1
                continue

            peak = 1
            while(i<n and ratings[i-1] < ratings[i]):
                peak+=1
                ans+=peak
                i+=1

            down = 1
            while (i<n and ratings[i-1] > ratings[i]):
                ans+= down
                i+=1
                down+=1
            
            if down > peak:
                ans+= down - peak
        
        return ans

# TC: O(n)   
# SC: O(1)