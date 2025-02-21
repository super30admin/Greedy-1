"""

There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.


Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 

Constraints:

n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104


Time Complexity: O(N) - We iterate through the list twice (left-to-right and right-to-left).
Space Complexity: O(N) - We use an additional array `arr` of size N to store the candy distribution.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach:
# used two passes to ensure each child gets the minimum number of candies required. 
# First, a left-to-right pass ensures that children with higher ratings than the previous child get more candies. 
# Then, a right-to-left pass ensures that children with higher ratings than the next child still receive more candies while maintaining the previous distribution.


class Solution:
    def candy(self, ratings: List[int]) -> int:

        arr = [1] * len(ratings)

        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i-1]:
                arr[i] = arr[i-1] + 1

        for i in range(len(ratings) - 2, -1, -1):
            if ratings[i] > ratings[i+1]:
                arr[i] = max(arr[i], arr[i+1] + 1)

        return sum(arr)


