"""
Brute force: distribute the candy based on the neighbours. Keep repeating until you keep finding breach.

Greedy apporach:
[4,3,2,5,6,8,10,9,7,6,4,3,1,9]

Until the point where the candies are decreasing, we need to increase. ex 4,3,2 the distribution is in reverse increasing.
1,2,3
For the point till where they are increasing ex: 5,6,7,8,the distribution is in increasing order as 2,3,4,5.
At the point of intersection the candies = max(right neighbor and left neighbor).
2 passes: one pass resolves the increasing numebers (left to right)
second pass: resolve the decreasing number (rigth to left)
TC: O(2n)

"""


class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        # initially, all children have one candy
        arr = [1 for _ in range(n)]

        # start from 1 since leftmost child has no left negighbour
        # only handle the increasing ratings
        for idx in range(1, n):
            if ratings[idx] > ratings[idx - 1]:
                # total candies from the left neighbour + 1
                arr[idx] = arr[idx - 1] + 1

        total = arr[n - 1]
        # only handle the decreasing ratings
        # start from second last since rightmost child has no right negighbour
        for idx in range(n - 2, -1, -1):
            if ratings[idx] > ratings[idx + 1]:
                arr[idx] = max(arr[idx], arr[idx + 1] + 1)

            total += arr[idx]

        return total



