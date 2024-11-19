# Greedy-1

## Problem1 Jump Game (https://leetcode.com/problems/jump-game/)

In this solution we will use BFS to determine if it is possible to jump from the first index to the last index in the array nums. We are using a queue to track the indices that can be reached, starting with index 0. We will maintain a set to avoid revisiting indices. For each index, we will explore all reachable indices based on the jump length. If any reachable index equals n-1 we will return true. If the queue is exhausted without reaching the last index, we will return false. In alternative DFS approach we will recursively explore possible paths using a flag to terminate early if the last index is reached.



## Problem2 Jump Game II (https://leetcode.com/problems/jump-game-ii/)

In this solution we aew determining the minimum number of jumps required to reach the end of the array using a Greedy Algorithm. We will maintain 2 variables for current interval boundary and for farthest reachable index in the next jump. We will traverse the array updating nextInt as the maximum reachable index at each step. When we will reach currInt, we will increment the jump count and update currInt to nextInt. If currInt covers the last index we will return the number of jumps. 



## Problem3 Candy (https://leetcode.com/problems/candy/)

We are using greedy approach to solve this problem. Here we will be going over the ratings array twice. In the first pass each child with higher rating than the previous ones gets one more candy than the previous child. Then in the second pass which will be from right to left we will make adjustments to ensure that children with higher ratings than the next child gets more candies. In the sum we will be taking sum of all the candies stored.


