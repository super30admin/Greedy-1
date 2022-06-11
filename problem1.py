#Jump Game
# // Time Complexity : O(N)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        destination=len(nums)-1
        for i in range(len(nums)-2, -1, -1):                #start from the end and see if the index + value will get you do the destination 
            if(nums[i]+i >= destination):
                destination = i
            
        return destination==0                           #if destination goes to 0th index, then return true, else false