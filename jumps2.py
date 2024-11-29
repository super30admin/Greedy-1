# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach


class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums)<2:
            return 0
        currInt=nums[0]
        nextInt=nums[0]
        jumps=1
        for i in range(1,len(nums)-1):
            
            nextInt=max(nextInt,i+nums[i])
            print(nextInt)
            if i==currInt:
            
                currInt=nextInt
                jumps+=1
        return jumps