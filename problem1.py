#time complexity: O(n)
#space complexity: O(1)
#ran on leetcode: Yes
#let destination be the last index. From n-1th element check if destination is reachable. If so, update destination to thios index. Finally after traversing the array, if destination is0, then this means that the final index can be reached, so return True. Else, return False
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        destination=len(nums)-1
        i=len(nums)-2
        while(i>=0):
            if(nums[i]+i>=destination):
                destination=i
            i-=1
        if(destination==0):
            return True
        return False

        
