# Brute-Force Using BFS
class Solution:
    def jump(self, nums: List[int]) -> int:
        if nums == None or len(nums) < 2:
            return 0
        q = deque()
        visited = set()
        q.append(0)
        visited.add(0)
        jumps = 0
        while q:
            size = len(q)
            for j in range(size):
                curr = q.popleft()
                value = nums[curr]
                for i in range(1, value+1):
                    newIdx = curr + i
                    if newIdx  == len(nums) -1:
                        return jumps + 1
                    if newIdx not in visited:
                        q.append(newIdx)
                        visited.add(newIdx)
            jumps += 1

# Time Complexity: O(n^n)
# Space Complexity: O(n)



class Solution:
    def jump(self, nums: List[int]) -> int:
        if nums == None or len(nums) < 2:
            return 0
        jumps = 1
        currInterval, nextInterval = nums[0], nums[0]
        for i in range(1, len(nums)):
            nextInterval = max(nextInterval, nums[i] + i)
            if i < len(nums)- 1 and i >= currInterval:
                jumps += 1
                currInterval = nextInterval
        return jumps

# Time Complexity: O(n)
# Space Complexity: O(1)
            