"""
Time Complexity: O(n)
    - Two full passes through the array (left → right, then right → left).

Space Complexity: O(n)
    - An auxiliary array `res` of size n is used to store candy counts.

Approach:
    - This is a two-pass greedy solution.
    - First pass (left to right): ensure that if a child has a higher rating than
      the previous child, they receive more candies.
    - Second pass (right to left): ensure the symmetric condition—if a child has a
      higher rating than the next child, they receive more candies.
    - The use of `max()` in the second pass guarantees both constraints are met.
    - Finally, sum all candies in `res` to get the total.
"""

class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        res = [1]*n

        for i in range(1, n):
            if ratings[i-1] < ratings[i]:
                res[i] = res[i-1] + 1
        
        for i in range(n-2, -1, -1):
            if ratings[i+1] < ratings[i]:
                res[i] = max(res[i], res[i+1] + 1)
        
        return sum(res)
