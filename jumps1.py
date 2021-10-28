# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        destination=len(nums)-1
        for i in range(len(nums)-2,-1,-1):
            print(destination)
            if i+nums[i]>=destination:
                print("x")
                destination=i
        return destination==0
        