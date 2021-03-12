#Time Complexity:O(n)
#Space Complexity:O(1)
class Solution:
    def jump(self, nums: List[int]) -> int:
        nextJump = float("-inf")
        currPos = 0
        jump = 0
        for i in range(len(nums)-1):
            nextJump = max(nextJump, i + nums[i])   #find maximum posiible jump from the current position i
            if currPos == i:                        #if current position and i are same, update currnt position to maxjump possible
                currPos = nextJump                  #update the jump by 1
                jump += 1
        return jump