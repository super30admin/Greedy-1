# Time Complexity :
# O (N^2)

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#We do a BFS traversal with the children being all the elements that can be reached from current element. We also store a visited array
#We pop the top element of the queue, and run through all it's children, check if they have been visited,  check if we have reached the end - if we have, we return the BFS level.
#If not we add the current element to the queue with the level and continue the BFS

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        self.visited = [False] * n
        if n==1 :
            return 0

        queue = collections.deque()
        queue.append((nums[0],0,0))
        min_jumps = 10**4 + 1 

        while len(queue) != 0 :
            curr_elem = queue.popleft()

            for i in range(1,curr_elem[0]+1):
                if i + curr_elem[1] == n-1 :
                    return curr_elem[2] +1

                if i+curr_elem[1] < n and self.visited[i+curr_elem[1]] == False :
                    queue.append((nums[i+curr_elem[1]],i+curr_elem[1],curr_elem[2]+1))
                    self.visited[i+curr_elem[1]] = True

        return min_jumps
