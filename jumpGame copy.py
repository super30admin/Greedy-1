#Time Complexity: O(N)
#Space Complexity: O(N)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # index we want to reach
		goal = len(nums) - 1
		# our current index, we start at the beginning
        cur = 0
		# number of steps we can take from where we are
        steps = nums[cur]
        
        while cur < goal and steps > 0:
            cur += 1
			
            steps = max(steps - 1, nums[cur])
            
        return cur == goal