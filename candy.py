# Approach: Greedy - two pass
# Initialize result arr with n elements - each set to 1 as each kid gets 1 candy at the minimum
# pass 1: go left to right, and give each kid one candy more than left neighbor if his rating is greater than left neighbor
# pass 2: go right to left, and compare with right neighbor and current value, and update res[i]= max(res[i], 1+res[i+1])
# TC: O(n)
# SC: O(n)
class Solution:
    def candy(self, ratings: List[int]) -> int:
        if not ratings or len(ratings) == 0:
            return 0
        
        n = len(ratings)
        if n == 1:
            return 1
        res = [1] * n
        # forward pass
        for i in range(1, n):
            if ratings[i] > ratings[i-1]:
                res[i] = 1 + res[i-1]
        total =  res[n-1]
        # backward pass
        for i in range(n-2, -1, -1):
            if ratings[i] > ratings[i+1]:
                res[i] = max(res[i], 1+res[i+1])
            total += res[i]
        
        return total