class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        if len(nums)<2:
            return True
        #BFS Soln give s TLE O(n^k)
        # Optimised BFS with set (Still O(n^k) but with optimized n). Giving TLE for Python
        
        # q = collections.deque()
        # h = set()
        # q.append(0)
        # h.add(0)
        # n = len(nums)-1
        # if n == 0:
        #     return True
        # while q:
        #     i = q.popleft()
        #     for j in range(nums[i],0,-1):
        #         newIdx = i+j
        #         if newIdx >= n:
        #             return True
        #         if newIdx not in h:
        #             q.append(newIdx)
        #             h.add(newIdx)
        # return False
                
        ##### Brute Force DFS ######
        
        #def dfs()
        
        
        
        
        # Greedy O(n) time O(1) space
        # if len(nums) < 2:
        #     return True
        # dest = len(nums) - 1
        # for i in reversed(range(len(nums) - 1)):
        #     if i + nums[i] >= dest:
        #         dest = i
        # return dest == 0
        
        #####  DP O(n) time and O(1) space #######
        if len(nums)==1:
            return True
        dp = [0 for _ in range(len(nums))]
        dp[0] = nums[0]
        
        for i in range(len(nums)-1):
            if dp[i] == 0:
                return False

            dp[i+1] = max(nums[i+1],dp[i]-1)
        return True
        
        #####  DP O(n) time and O(1) space
        if len(nums)==1:
            return True
        dp = nums[0]
        
        for i in range(1,len(nums)):
            if dp == 0:
                return False
            dp -= 1
            dp = max(dp,nums[i])
        return True

