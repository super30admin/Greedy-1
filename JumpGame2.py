# Time Complexity : O(n) 
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
# 1) Take first element and the that number is the maximum jumps that we can go starting from 1.
# 2) nextInt will track the number, a number that will tell the maximum jump that we can dive, 
#    during the iteration untill we reach the currInt that was where we started from. 
# 3) if we reach the currInt, so we reached our inital destination, so we incremenet the jump by 1. 
class Solution:
    def jump(self, nums):
        if len(nums) < 2:
            return 0 
        jump = 1 
        currInt = nums[0]
        nextInt = nums[0]
        for i in range(1,len(nums)):
            if nums[i] + i > nextInt:
                nextInt = nums[i] + i 
     
            if i < len(nums)-1 and i == currInt:
                currInt = nextInt 
                jump += 1
            
        return jump

if __name__ == "__main__":
    s = Solution()
    
    # Test case 1 
    print(s.jump([2, 3, 1, 1, 4]))