# Approach : DFS
# TC: Exponential O(2^n)
# SC: O(log n)
class Solution:
    def __init__(self):
        self.dp = None
    def canJump(self, nums: List[int]) -> bool:
        self.dp = [None] * len(nums)
        
        def helper(index) -> bool:
            # base
            if index >= len(nums)-1:
                return True
            
            if self.dp[index] != None:
                return self.dp[index]
            
            # logic
            for i in range(1, nums[index]+1):
                nxt_index = index+i 
                if helper(nxt_index):
                    if nxt_index < len(nums) - 1:
                        self.dp[nxt_index] = True
                    return True
                else:
                    if nxt_index < len(nums) -1 :
                        self.dp[nxt_index] = False
            return False
        return helper(0)
    
# Approach: DP
# TC: O(n)
# SC: O(1)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) == 1: return True # base case
        # greedy approach
        # set goal to last index of the array
        goal = len(nums) - 1
        # iterate in reverse order
        # at each step see if current index + value at the index >= goal
        # if yes, then new goal will be current index.
        # because in theory, we know that if we can go from current index to the goal
        # then all we need to check next is can we go from currentIndex-1 to currentIndex
        # in this way we can tell if we can jump from start to end. And return True if goal reached == 0
        for i in range(len(nums) - 2, -1, -1):
            if i + nums[i] >= goal:
                goal = i
                if goal == 0:
                    return True
        return False