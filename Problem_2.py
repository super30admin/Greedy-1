'''
45 Jump Game II
https://leetcode.com/problems/jump-game-ii/description/

You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0. Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:
    0 <= j <= nums[i] and
    i + j < n

Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.


Example 1:
Input: nums = [2,3,1,1,4]
Output: 2  (2->3, 3->4)
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2 (2->3, 3->4)

Example 3:
Input: nums = [10,9,8,7,6,5,4,3,2,1,1,0]
Output: 2 (10->1, 1->0)

Example 4:
Input: nums = [3,4,2,1,1,2,2,1]
Output: 2 (10->1, 1->0)

Constraints:
1 <= nums.length <= 10^4
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].

Solution:
1. BFS
Bread first search using level information
https://youtu.be/zx_64qoVVho?t=266
Time: O(exponential), Space: O(N)

2. DFS
Depth first search using depth information
https://youtu.be/zx_64qoVVho?t=1219
Time: O(exponential), Space: O(N)

3. Greedy
We use a greedy approach to track the range of indices that we can reach at every jump. We start with jump=0 which has a range = [0,0] (left=0, right=0)
For jump = 1, we find a new range = [new left, new right]. Here, new_left = old right + 1, new right = farthest index reachable by jumping from the previous interval. We increment jump by 1. We stop if right >= N-1 (last index).
https://youtu.be/7SBVnw7GSTk?t=27 (easier to understand)
https://youtu.be/zx_64qoVVho?t=2181
Time: O(N), Space: O(1)

'''
from typing import List
from collections import deque

def jump_bfs(nums: List[int]) -> int:
    ''' Time: O(exponential), Space: O(N) '''
    if not nums or len(nums) == 1:
        return 0
    N = len(nums)
    q = deque()
    visited = set()
    q.append(0)
    visited.add(0)
    lvl = -1
    while q:
        lvl += 1
        for _ in range(len(q)):
            j = q.popleft()
            if j == N-1: # last index
                return lvl
            for i in range(1,nums[j]+1):
                child = j  + i
                if child not in visited:
                    q.append(child)
                    visited.add(child)
    return -1

def jump_dfs(nums: List[int]) -> bool:
    ''' Time: O(exponential), Space: O(N) '''
    def dfs(j, nums, jumps):
        nonlocal m
        if j >= N-1:
            return jumps

        for i in range(1, nums[j]+1):
            child = j  + i
            n = dfs(child, nums, jumps+1)
            m = min(m, n)
        return m

    if not nums or len(nums) == 1:
        return True
    N = len(nums)
    m = float('inf') # min no. of jumps to reach last index
    jumps = 0
    dfs(0, nums, jumps)
    return m

def jump_greedy(nums: List[int]) -> int:
    ''' Time: O(N), Space: O(1) '''
    if not nums or len(nums) == 1:
        return 0
    N = len(nums)
    left, right = 0, 0
    min_jumps = 0 # min no. of jumps to destination

    # Track the range of indices for each jump
    while right < N-1:
        print(f"jump = {min_jumps}, range = {[left, right]}")

        # find the new right index for the next jump
        farthest = 0
        for i in range(left, right+1):
            farthest = max(i + nums[i], farthest)
        left = right + 1
        right = farthest
        min_jumps += 1
    print(f"jump = {min_jumps}, range = {[left, right]}")
    return min_jumps

def run_jump():
    tests = [([2,3,1,1,4], 2), ([2,3,0,1,4], 2),
             ([10,9,8,7,6,5,4,3,2,1,1,0], 2),
             ([3,4,2,1,1,2,2,1],3),
    ]
    for test in tests:
        nums, ans = test[0], test[1]
        print(f"\nnums={nums}")
        for method in ['bfs','dfs', 'greedy']: #'greedy']:
            if method == 'bfs':
                result = jump_bfs(nums)
            elif method == 'dfs':
                result = jump_dfs(nums)
            elif method == 'greedy':
                result = jump_greedy(nums)
            print(f"Method {method}: Min jumps to last index = {result}")
            success = (ans == result)
            print(f"Pass: {success}")
            if not success:
                print(f"Failed")
                return
run_jump()