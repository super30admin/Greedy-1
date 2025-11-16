class Solution(object):
    # Tc : O(n)
    # sc : O(1)
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        # instead of jumping from forward, lets take the end index as our target and see if we could reach last index from 0
        # for each idex i from right to left, lets see if we can jump from i to the target and if it is then i will be our new target we keep dng this until we reach the 0th index 
        # means we were able to jump 0 index to last positon, doing backwards helps because in forward way we have to exhaustively check the 
        # all possibilities on whihc position to land next so we can reach end , in this way we are cmg from back and checking if this index can jump far enough to reach the target,  eliminating the exhuastive search

        n = len(nums)

        # edge case
        if n == 1:
            return True
        
        target = n-1
        for i in range(n-2,-1,-1):
            if nums[i] + i >= target:
                target = i 
        
        return target == 0