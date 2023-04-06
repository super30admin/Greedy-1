"""
Rasika Sasturkar
Time Complexity: O(2n) = O(n)
Space Complexity: O(n), for extra array
"""


def candy(ratings) -> int:
    # null case
    if ratings is None:
        return 0

    n = len(ratings)
    candies = [1 for _ in range(n)]

    # left pass
    for i in range(1, n):
        if ratings[i] > ratings[i - 1]:
            candies[i] = candies[i - 1] + 1

    total = candies[-1]

    # right pass
    for i in range(n - 2, -1, -1):
        if ratings[i] > ratings[i + 1]:
            candies[i] = max(candies[i], candies[i + 1] + 1)
        total += candies[i]

    return total


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(candy(ratings=[1, 0, 2]))  # returns 5
    print(candy(ratings=[1, 2, 2]))  # returns 4


if __name__ == "__main__":
    main()
