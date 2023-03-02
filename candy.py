# Time Complexity : O(n), Where n is number of elements in nums List
# Space Complexity : O(1)

class Solution:
    def candy(self, ratings: List[int]) -> int:
        out = [1 for i in range(len(ratings))]
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i-1]:
                out[i] = out[i-1]+1

        for i in range(len(ratings)-2, -1, -1):
            if ratings[i] > ratings[i+1]:
                out[i] = max(out[i], out[i+1]+1)
        return sum(out)
