"""
Rasika Sasturkar
Time Complexity: Exhaustive - O(n^k), k is no. of jumps, Greedy - O(n)
Space Complexity: Exhaustive - O(n), Greedy - O(1)
"""

import collections


def canJump(nums) -> bool:
    if len(nums) < 2:
        return True

    # Using BFS
    # n = len(nums) - 1
    # queue = collections.deque([0])
    # visited = set()
    # visited.add(0)
    #
    # while queue:
    #     i = queue.popleft()
    #     for j in range(nums[i], 0, -1):
    #         new_idx = i + j
    #         if new_idx >= n:
    #             return True
    #         if new_idx not in visited:
    #             queue.append(new_idx)
    #             visited.add(new_idx)
    # return False

    # Using DFS
    # dp = [-1 for _ in range(len(nums))]
    #
    # def dfs(nums, i):
    #     # base case
    #     if i >= len(nums) - 1:
    #         return True
    #     if dp[i] == 2:
    #         return False
    #
    #     # logic
    #     maxx = nums[i]
    #     dp[i] = 1
    #     for j in range(maxx, 0, -1):
    #         new_idx = i + j
    #         if new_idx >= len(nums) - 1:
    #             return True
    #         if dp[new_idx] == -1 and dfs(nums, new_idx):
    #             return True
    #     dp[i] = 2
    #     return False
    #
    # return dfs(nums, 0)

    # Using greedy approach
    dest = len(nums) - 1
    for i in range(len(nums) - 2, -1, -1):
        if i + nums[i] >= dest:
            dest = i
    return dest == 0


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(canJump(nums=[2, 3, 1, 1, 4]))  # returns True
    print(canJump(nums=[3, 2, 1, 0, 4]))  # returns False


if __name__ == "__main__":
    main()
