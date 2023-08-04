
'''
Problem: Candy
Time Complexity: O(n), where n is given elements
Space Complexity: O(n)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        traverse left to right and comapre candies with left neighbor
        traverse right to level and compare candies with right neighbor
        get sum of max of both  
'''

class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        result = [1] * n

        for i in range(1, n):
            if ratings[i]>ratings[i-1]:
                result[i]= result[i-1] + 1
        
        for i in range(n-2, -1, -1):
            if ratings[i]>ratings[i+1]:
                result[i]= max(result[i], result[i+1] + 1)
        
        return sum(result)