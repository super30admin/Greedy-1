class Solution:
    def canJump(self, nums: List[int]) -> bool:
        '''
        Greedy: O(n)
        Choose Maximum
        '''
        maxm = 0
        for i in range(0,len(nums)):
            if(i>maxm):
                return False
            maxm = max(maxm,i + nums[i])
        
        return True
