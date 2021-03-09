
"""
Time Complexity : O(n)- 2n to be precise
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Your code here along with comments explaining your approach:
Here, we make a temp array of size of length of ratings array. We iterate through the array, if right child has 
higher rating, we increase his candy by one from left child. After complete iteration, we traverse from
right side and if left child has more rating, we increase his rating by one from right child. At the end,
we calculate total number of candies.
"""


class Solution:
    def candy(self, ratings: List[int]) -> int:
        l = len(ratings)
        arr = [1 for i in range(l)]
        total = 0
        for i in range(1, l):
            if ratings[i] > ratings[i-1]:
                arr[i] = arr[i-1]+1
        total += arr[-1]
        for i in range(l-2, -1, -1):
            if ratings[i] > ratings[i+1] and not arr[i] > arr[i+1]:
                arr[i] = arr[i+1]+1
            total += arr[i]
        return total
