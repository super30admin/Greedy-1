# Approach - In line
# Time - O(N)
# Space - O(N)

class Solution:

    def candy(self, ratings: List[int]) -> int:
        
        if not ratings or len(ratings) == 0:
            return 0
        
        result = [1] * len(ratings) ##c initially assign one candy for all children

        # left pass, start from 1 inorder to compare with left neighbor
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i-1]:
                result[i] = result[i-1] + 1 # give one more than the neighbor not add one to itself
        
        # right pass
        for i in range(len(ratings)-2, -1, -1):
            if ratings[i] > ratings[i+1]:
                result[i] = max(result[i], result[i+1]+1)
        
        return sum(result)