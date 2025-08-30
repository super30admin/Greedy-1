'''
55 Jump Game
https://leetcode.com/problems/jump-game/description/

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

Constraints:
1 <= nums.length <= 10^4
0 <= nums[i] <= 10^5

1. BFS
Enque the first index. Pop index.
Find the value of the index, nums[index]. This is the max number of jumps we can make from index. Thus, enque index+1, index+2,..., index+nums[index].
To avoid enqueing the same index again, maintain a visited array which is set to True as soon as we enque an index. We return True if we reach index = N-1.
If we have processed all the elements in the queue and we still haven't reached N-1, we return False.
https://youtu.be/Y4KgFy8gB34?t=2775
Time: O(exponential), Space: O(N)

2. DFS
Similar to BFS but depth traversal.
https://youtu.be/Y4KgFy8gB34?t=3579
Time: O(exponential), Space: O(N)

3. Greedy
Treat the last index (N-1) as the target destination we need to reach.
Moving index backward from N-2 to 0, we check if it is possible to jump from the current index to the target destination on the right (or beyond the target destination). If such a jump is possible, we update the target destination to the current index and move on to the next left index (index = index-1).
If such a jump is not possible, we do not update the target destination but move on to the next left index (index = index - 1).

Why is this a greedy approach? At each target destination, we are taking a decision based on whether we can take a max jump from the current index to reach the destination (or go past it), i.e. i + nums[i] >= destination. Thus, we are making locally optimal decisions.

https://youtu.be/Y4KgFy8gB34?t=4418
Time: O(N), Space: O(1)
'''
from typing import List
from collections import deque

def canJump_bfs(nums: List[int]) -> bool:
    ''' Time: O(exponential), Space: O(N) '''
    if not nums or len(nums) == 1:
        return True
    N = len(nums)
    q = deque()
    visited = set()
    q.append(0)
    visited.add(0)
    while q:
        j = q.popleft()
        if j == N-1: # last index
            return True

        for i in range(1,nums[j]+1):
            child = j  + i
            if child not in visited:
                q.append(child)
                visited.add(child)
    return False

def canJump_dfs(nums: List[int]) -> bool:
    ''' Time: O(exponential), Space: O(N) '''
    def dfs(j, nums):
        if j == N-1:
            return True
        if j in visited:
            return False

        found = False
        visited.add(j)
        for i in range(1, nums[j]+1):
            child = j  + i
            if child not in visited:
                found = dfs(child, nums)
                if found:
                    break
        return found

    if not nums or len(nums) == 1:
        return True
    N = len(nums)
    visited = set()
    return dfs(0, nums)

def canJump_greedy(nums: List[int]) -> bool:
    ''' Time: O(N), Space: O(1) '''
    if not nums or len(nums) == 1:
        return True
    N = len(nums)
    destination = N-1
    for i in range(N-2,-1,-1):
        if i + nums[i] >= destination:
            destination = i
    return destination == 0

def run_canJump():
    tests = [([2,3,1,1,4], True), ([3,2,1,0,4], False)]
    for test in tests:
        nums, ans = test[0], test[1]
        print(f"\nnums={nums}")
        for method in ['bfs', 'dfs', 'greedy']:
            if method == 'bfs':
                result = canJump_bfs(nums)
            elif method == 'dfs':
                result = canJump_dfs(nums)
            elif method == 'greedy':
                result = canJump_greedy(nums)
            print(f"Method {method}: Last index reachable = {result}")
            success = (ans == result)
            print(f"Pass: {success}")
            if not success:
                print(f"Failed")
                return

run_canJump()
