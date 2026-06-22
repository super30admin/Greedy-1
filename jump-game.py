# O(n) time, O(1) space
# A greedy algorithm is a problem-solving strategy that builds up a solution piece by piece. At every single step, it chooses the option that looks the best right then and there, without worrying about the future or the bigger picture.

# In technical terms, it makes a locally optimal choice in the hopes that these choices will lead to a globally optimal solution.
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        t=len(nums)-1 # t is target
        #  0 1 2 3 4
        #  t
        # [2,3,1,1,4]
        #  i
        # t=0
        for i in range(len(nums)-2,-1,-1):
            # i is current index, nums[i] is max jump length at i
            # therefore, i + nums[i] is the furthest index you can reach from your current position
            # if furthest reachable point is greater or equal than target, then if you can just manage to get to i, you are gauranteed to be able to reach target
            if i + nums[i] >= t:
                # you can reach the target, so move target to current position
                t = i
        if t == 0:
            return True
        return False 