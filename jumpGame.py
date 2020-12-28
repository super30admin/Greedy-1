# As tught in class, using DFS to solve this problem
#Time Complexity: O(h)
#Space Complexity: O(h)
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums is None or len(nums)<2:
            return True
        return self.dfs(nums,0)
    
    def dfs(self,nums,index):
        if index == len(nums) -1:
            return True
        for i in range(1,nums[index]):
            if (self.dfs(nums,index+i)):
                return True
        return False
        