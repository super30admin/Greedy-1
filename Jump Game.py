# Time:- O(n)
# Space:- O(1)
# Approach:- In a bottom up manner mark every node which can take us to the destination(last index) as 
# the destination index and keep going back. Why this works, now there is no choice
# to be made there is only one choice to be made take the max jump from the every node and check 
# if we can get to the destination node. This gives a O(n) solution as compared to the DP or backtracking
#  where we were making choices in a top down manner. In backtracking we were naively exploring all
#  the choices from a node. In DP we were marking the node which took us to the destination as True
#  and which cant take us to the destination as False therefore avoiding recomputation. 
class Solution:
    def canJump(self, nums) -> bool:
        # Bottom up:- O(n)Greedy
        destination=len(nums)-1
        for i in range(destination-1,-1,-1):
            if i+nums[i]>=destination:
                destination=i
        return destination==0
        # # DFS(Backtracking(2^n) or DP Top Down(n^2)):- TLE
        @lru_cache(maxsize=None)
        def canreach(index):
            if index>=len(nums)-1:
                return True
            for i in range(1,nums[index]+1):
                if canreach(index+i):
                    return True
            return False
        return canreach(0)