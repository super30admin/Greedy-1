# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Start from reverse as the end goal is fixed. Mark it as destination
2. if index + number of jumps from that index >= destination, then we can say that it is viable to reach det and vice versa
3. At any point if its true, the destination changes to curr index and we continue until we reach index 0
4. If destination becomes 0, we return True else False
'''
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        if not nums or len(nums) < 1:
            return True
        
        dest = len(nums)-1
        for i in range(len(nums)-2,-1,-1):
            
            if i+nums[i] >= dest:
                dest = i
            
            if i == 0 and i+nums[i] < dest:
                return False
        
        return True
            
        