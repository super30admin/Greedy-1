# Time Complexity : O(N) where N number of ranting in the array
# Space Complexity : O(N) where N number of ranting in the array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def candy(self, ratings: List[int]) -> int:
        dist = [1 for _ in range(len(ratings))]
        for i in range(1, len(ratings)):        
            if ratings[i] > ratings[i-1]:
                if dist[i] <= dist[i-1]:
                    dist[i] = dist[i-1] + 1
        
        for i in range(len(ratings) - 2, -1, -1):        
            if ratings[i] > ratings[i+1]:
                if dist[i] <= dist[i+1]:
                    dist[i] = dist[i+1] + 1

        return sum(dist)