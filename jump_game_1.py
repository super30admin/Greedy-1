# Time Complexity :
# O (N)

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
#Yes

#We start from passing through the element in reverse. The initial target is the last locaiton. We check if the ltarget can be reached from the current location, if it does, the target is udpated
#If at the end, the target has reached 0, then it means we have a path from first element to last and we return True. Else we return False

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        self.n = len(nums)
        if self.n==1 :
            return True

        current_target = self.n-1
        for i in reversed(range(0,self.n-1)):
            if nums[i] + i >= current_target :
                current_target = i

        if current_target == 0 :
            return True
        else :
            return False
