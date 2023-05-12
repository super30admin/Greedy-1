# Time Complexity : O(N), where N is the length of the input array. 
# Space Complexity : O(N), where N is the length of the input array.
from collections import deque
from typing import List

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return 0
        
        # Initialize the queue and visited array
        q = deque()
        visited = [False] * n
        
        # Add the first node to the queue and mark it as visited
        q.append((0, 0))
        visited[0] = True
        
        while q:
            node, jumps = q.popleft()
            
            # Consider all the nodes that can be reached from the current node
            for i in range(1, nums[node] + 1):
                next_node = node + i
                
                # If we have reached the last node, return the minimum number of jumps required to reach it
                if next_node == n - 1:
                    return jumps + 1
                
                # Add the next node to the queue and mark it as visited
                if next_node < n and not visited[next_node]:
                    q.append((next_node, jumps + 1))
                    visited[next_node] = True
        
        # If we cannot reach the last node, return -1
        return -1