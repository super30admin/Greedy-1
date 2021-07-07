'''
Solution:
1.	This can be done using a greedy strategy in both forward and in backward direction.
2.	In any direction, the main thing is that whenever we can jump a particular number of steps
	from one particular index, just update the destination (or farthest) pointers
3.	At the end, check whether this pointer reaches the other end of the array or not.

Time Complexity:	O(N)	|	Space Complexity:	O(1)

--- Passed all testcases on leetcode successfully for both the solutions.
'''


class CanJumpForward:
    def canJump(self, nums: List[int]) -> bool:
        
        #	edge case check
        if (nums == None or len(nums) < 2):
            return True
        
        #	initialization 
        farthest = 0
        
        #	iterate
        for i in range(len(nums) - 1):

        	#	reaching this condition => index is ahead of existing farthest which means
        	#	any index from current index to last index can't be reached  
            if (i > farthest):
                return False

            #	update farthest
            farthest = max(i + nums[i], farthest)
        
        #	return whether farthest is out of the array        
        return (farthest >= len(nums) - 1)


class CanJumpBackward:
    def canJump(self, nums: List[int]) -> bool:
        
        #	edge case check
        if (nums == None or len(nums) < 2):
            return True
        
        #	initialization
        destination = len(nums) - 1
        
        #	iterate
        for i in range(destination - 1, -1, -1):

        	#	reaching the condition => update destination to current index
            if (i + nums[i] >= destination):
                destination = i
        
        #	check whether destination reaches index 0 => from end to first index      
        return (destination == 0)