"""
# Greedy-1

## Problem1 Jump Game (https://leetcode.com/problems/jump-game/)

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]

Output: true

Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: [3,2,1,0,4]

Output: false

Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.

 time- O(n)
 space - constant

"""
def canJump(input):
    if len(input)==0:
        return True
    max_reach=0
    for i in range(len(input)):
        if max_reach < i:
            return False
        max_reach = max(max_reach, i + input[i])

    return True

print(canJump( [3,2,1,0,4]))