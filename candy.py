"""
Time Complexity : O(2n) => O(n) where n is the length of the ratings array
Space Complexity : O(n) where n is the length of the ratings array

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes


Your code here along with comments explaining your approach
1. Initialize the result array with 1 with number of children as every child must get at least one candy
2. Then, in the first path, start with index 1 and compare the left child's rating with the current child, if it current child's rating is greater than give one more candy than the left child to the current child.
3. In the second pass, start from second last child and compare the right child's rating with the current child's rating, if the current child's rating is greater then take the maximum of current child candies and one more than the right child's candy.
4. At the end return the result array
"""


class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        ans = 0
        if n == 0:
            return ans

        result = [1 for _ in range(n)]
        # left pass
        for i in range(1, n):
            if ratings[i] > ratings[i-1]:
                result[i] = result[i-1] + 1

        # right pass
        for i in range(n-2, -1, -1):
            if ratings[i] > ratings[i+1]:
                result[i] = max(result[i], result[i+1] + 1)
            ans += result[i]
        ans += result[-1]
        return ans
