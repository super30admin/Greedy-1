"""
## Problem2 Jump Game II (https://leetcode.com/problems/jump-game-ii/)

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]

Output: 2

Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.

Note:
You can assume that you can always reach the last index.

time- O(n)
space - constant

"""
def jumps(input):
    if len(input)==0:
        return 0
    max_reach=0
    numofjumps=0
    curr_reach=0
    for i in range(len(input)-1): # loop will be till 2nd last
        max_reach=max(max_reach, i + input[i])
        if i == curr_reach:
            numofjumps += 1
            curr_reach=max_reach
    return numofjumps

print(jumps([0]))