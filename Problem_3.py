'''
135 Candy
https://leetcode.com/problems/candy/description/

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

Example 3:
Input: ratings = [7,5,4,3,2,1]
Output: 21 (since candies = [6,5,4,3,2,1])

Example 4:
Input: ratings = [1,2,3,4,5,7]
Output: 21 (since candies = [1,2,3,4,5,6])

Example 5:
Input: ratings = [1,2,10,12,3,1]
Output: 13 (since candies = [1,2,3,4,2,1])


Constraints:
    n == ratings.length
    1 <= n <= 2 * 10^4
    0 <= ratings[i] <= 2 * 10^4

Solution:
Let rating[i] = rating for child i

1. Sorting and comparing
Assign 1 candy to each child.
Sort ratings by ascending order and store the sorted ratings in a new array 'sratings'. Pick each rating from sratings starting from the smallest rating (sratings[0]). The child corresponding to sratings[i] is the ref child. Assign candies to ref child by comparing left and right neighbors of the picked rating.
if rating[ref] > rating[left], candy[ref] = candy[left] + 1. Else, do nothing.
if rating[ref] > rating[right], candy[ref] = max(candy[left]+1, candy[right] + 1) = max(candy[ref], candy[right+1]). Else, do nothing.
https://youtu.be/Y4KgFy8gB34?t=1618
Time: O(N log N + N) = O(N log N), Space: O(N)

2. Two passes
Give each child 1 candy each. Thus, candy[i] = 1, for i=0,...N-1

Step 1: Forward pass (Compare curr with left neighbor)
for i=1,,,N-1
let curr = rating[i], prev = rating[i-1].
If curr > prev, then child i should get 1 candy more than child i-1. Thus, candy[i] = candy[i-1] + 1
If curr <= prev, then child i should not get more candies than child i-1. Thus, do not modify candy[i].
Example: ratings = [1,2,10,12,3,1]
after forward pass, candies = [1,2,3,4,1,1]

Step 2: Backward pass (Compare curr with right neighbor)
for i=N-2,..,0
let curr = rating[i], prev = rating[i+1].
If curr > prev, then child i should get 1 candy more than child i+1. But if ratings[i] > ratings[i-1], then we must ensure that candy[i] > candy[i-1].

We already know candy[i] contains the correct no. of candies for child i after comparing with child i-1 (after forward pass). We are only left with the right neighbor. During the backward pass, we want to ensure that child i receives more candies than child i+1 while also receiving more candies than child i-1.
To satisfy both the conditions for the left and right neighbors, we set candy[i] = max(candy[i], candy[i+1] + 1).

If curr <= prev, then child i should not get more candies than child i+1. Thus, do not modify candy[i].
Example: ratings = [1,2,10,12,3,1]
after backward pass, candies = [1,2,3,4,2,1]
Note this case: candy[3] = max(candy[3], candy[4]+1) = max(4, 3) = 4

Step 3: Sum
Finally, sum the values of the candies array. Return sum.
https://youtu.be/Y4KgFy8gB34?t=721
Time: O(3N) = O(N), Space: O(N) (create candies array)
'''
from typing import List
def candy(ratings: List[int]) -> int:
    N = len(ratings)
    candies = [1]*N
    # Check each child's rating with its left neighbor
    for i in range(1,N):
        if ratings[i] > ratings[i-1]:
            candies[i] = candies[i-1] + 1

    # Check each child's rating with its right neighbor
    for i in range(N-2,-1,-1):
        if ratings[i] > ratings[i+1]:
            candies[i] = max(candies[i], candies[i+1] + 1)

    sum = 0
    for i in range(N):
        sum += candies[i]
    return sum

def run_candy():
    tests = [([1,0,2],5), ([1,2,2],4),
             ([7,5,4,3,2,1],21), # decreasing
             ([1,2,3,4,5,7],21), # increasing
             ([1,2,10,12,3,1],13), # increasing then decreasing
    ]
    for test in tests:
        ratings, ans = test[0], test[1]
        result = candy(ratings)
        print(f"\nratings = {ratings}")
        print(f"result = {result}")
        success = (ans == result)
        print(f"Pass: {success}")
        if not success:
            print(f"Failed")
            return

run_candy()