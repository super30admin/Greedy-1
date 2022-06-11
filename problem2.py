#Jump Game 2


# // Time Complexity : O(N)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def jump(self, nums: List[int]) -> int:
        left=right=0
        res=0
        
        while (right <len(nums)-1):
            maximum=0
            for i in range(left,right+1):               #starting with the first index, find the maximum you can go
                maximum = max(maximum, nums[i]+i)
            left=right+1                                #after going  through each level, set the left to the current right +1
            right = maximum                             # set right to the next maximum you can go to
            res+=1
            
        return res
                
        
        